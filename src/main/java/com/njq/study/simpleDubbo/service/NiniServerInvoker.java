package com.njq.study.simpleDubbo.service;

import com.njq.study.simpleDubbo.NinaInovker;
import com.njq.study.simpleDubbo.Request;
import com.njq.study.simpleDubbo.Response;
import com.njq.study.simpleDubbo.test.TestApi;
import com.njq.study.simpleDubbo.test.TestApiImpl;
import javassist.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class NiniServerInvoker<T> implements NinaInovker {


    T ref;

    Class<T> type;

    final Wrapper wrapper;


    public NiniServerInvoker(T ref, Class<T> type) throws Exception {
        this.ref = ref;
        this.type = type;
        wrapper = createWrapper();
        wrapper.setType(type);
        wrapper.setRef(ref);
    }

    @Override
    public Response invoke(Request request) throws Throwable {
        Response response = new Response(request.getId());
        try {
            Object invoke = wrapper.invoke(request.getMethod(), request.getParams());
            response.setResult(invoke);
        } catch (Exception e) {
            response.setE(e);
        }

        return response;
    }

    @Override
    public boolean destory() throws Throwable {
        // TODO: 2018/11/2
        return false;
    }


    private Wrapper createWrapper() throws Exception {

        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass(type.getName() + "$Wrapper");
        CtField refField = new CtField(pool.getCtClass("java.lang.Object"), "ref", ctClass);
        CtField typeField = new CtField(pool.getCtClass("java.lang.Class"), "type", ctClass);
        refField.setModifiers(Modifier.PRIVATE);
        typeField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(refField);
        ctClass.addField(typeField);


        ctClass.addMethod(CtNewMethod.setter("setRef", refField));
        ctClass.addMethod(CtNewMethod.setter("setType", typeField));


        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        ctClass.addInterface(pool.get(Wrapper.class.getName()));


        StringBuilder sb = new StringBuilder();
        sb.append(" public  Object invoke(String method,Object[] params){\n ")
                .append(type.getName()).
                append(" o=(").append(type.getName()).append(")ref;\n");
        Method[] declaredMethods = type.getDeclaredMethods();
        boolean isVoid = false;
        if (declaredMethods != null) {
            for (Method m : declaredMethods) {
                sb.append(" if(method.equals(\"").append(m.getName()).append("\")){\n ");
                Wrapper.ParamDefine[] paramDefines=null;

                //处理入参的基本类型
                if (m.getParameterCount() > 0) {
                    paramDefines=new Wrapper.ParamDefine[m.getParameterCount()];
                    Class<?>[] parameterTypes = m.getParameterTypes();
                    // TODO: 2018/11/3
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Wrapper.ParamDefine define=null;
                        if(parameterTypes[i]==int.class){
                            define=new Wrapper.ParamDefine("","((Integer)params["+i+"]).intValue()",true);
                        }else if(parameterTypes[i]==boolean.class){
                            define=new Wrapper.ParamDefine("","((Float)params["+i+"]).floatValue()",true);
                        }else if(parameterTypes[i]==double.class){
                            define=new Wrapper.ParamDefine("","((Double)params["+i+"]).doubleValue()",true);
                        }else if(parameterTypes[i]==double.class){
                            define=new Wrapper.ParamDefine("","((Long)params["+i+"]).longValue()",true);
                        }else if(parameterTypes[i]==byte.class){
                            define=new Wrapper.ParamDefine("","((Byte)params["+i+"]).byteValue()",true);
                        }else{
                            define=new Wrapper.ParamDefine("("+parameterTypes[i].getName()+")","params["+i+"]",false);
                        }

                        if(define!=null){
                            paramDefines[i]=define;
                        }


                    }


                }


                Class<?> returnType = m.getReturnType();
                if (returnType == void.class) {
                    isVoid = true;
                    sb.append(" o.").append(m.getName());
                } else if (returnType.isPrimitive()) {
                    if (returnType == boolean.class) {
                        sb.append("boolean b=o.").append(m.getName());
                    } else if (returnType == int.class) {
                        sb.append("int b=o.").append(m.getName());
                    } else if (returnType == double.class) {
                        sb.append("double b=o.").append(m.getName());
                    } else if (returnType == float.class) {
                        sb.append("float b=o.").append(m.getName());
                    } else if (returnType == long.class) {
                        sb.append("long b=o.").append(m.getName());
                    }else if (returnType == byte.class) {
                        sb.append("byte b=o.").append(m.getName());
                    }


                } else {
                    sb.append("Object result=o.").append(m.getName());
                }

                if (m.getParameterCount() > 0) {
                    for (int i = 0; i < paramDefines.length; i++) {

                        sb.append("(").append(paramDefines[i].type).append(paramDefines[i].parms);
                        if (i != paramDefines.length - 1) {
                            sb.append(",");
                        }

                    }

                    sb.append(");\n");

                } else {
                    sb.append("();\n");
                }


                if (isVoid) {
                    sb.append("return null;}\n");
                    isVoid = false;
                } else if (returnType == boolean.class) {
                    sb.append(" Boolean result=Boolean.valueOf(b);\n");
                    sb.append("return result;}\n");
                } else if (returnType == int.class) {
                    sb.append(" Integer result=Integer.valueOf(b);\n");
                    sb.append("return result;}\n");
                } else if (returnType == double.class) {
                    sb.append(" Double result=Double.valueOf(b);\n");
                    sb.append("return result;}\n");
                } else if (returnType == float.class) {
                    sb.append(" Float result=Float.valueOf(b);\n");
                    sb.append("return result;}\n");
                } else if (returnType == long.class) {
                    sb.append(" Long result=Long.valueOf(b);\n");
                    sb.append("return result;}\n");
                } else {
                    sb.append("return result;}\n");
                }
            }
            sb.append("throw new RuntimeException(\"远程调用失败,没有此方法！\");}");
        }
//        System.out.println(sb.toString());
        CtMethod m = CtNewMethod.make(sb.toString(), ctClass);
        m.setModifiers(Modifier.PUBLIC);
        ctClass.addMethod(m);


        Class aClass = ctClass.toClass();
        return (Wrapper) aClass.newInstance();

    }

    public interface Wrapper {

        Object invoke(String method, Object[] params);

        void setRef(Object ref);

        void setType(Class type);

        /**
         * wrapper中参数描述
         */
        class ParamDefine{
            String type;

            String parms;

            boolean isPrimitive;

            public ParamDefine(String type, String parms, boolean isPrimitive) {
                this.type = type;
                this.parms = parms;
                this.isPrimitive = isPrimitive;
            }
        }


    }



    public static void main(String[] args) throws Exception {
        TestApiImpl testApi = new TestApiImpl();
        Class<TestApi> testApiClass = TestApi.class;
        NiniServerInvoker niniServerInvoker = new NiniServerInvoker(testApi, testApiClass);
        Wrapper wrapper = niniServerInvoker.wrapper;
        wrapper.setRef(testApi);
        wrapper.setType(testApiClass);
        Object speek1 = wrapper.invoke("setInt", new Object[]{2});
        System.out.println(speek1);
    }



}
