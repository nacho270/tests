#include <stdio.h>

#include "main_Test.h"

JNIEXPORT jstring JNICALL Java_main_Test_testJNI(JNIEnv *env, jclass c){
          return (*env)->NewStringUTF(env,"Hola JNIIIII\n");
}
