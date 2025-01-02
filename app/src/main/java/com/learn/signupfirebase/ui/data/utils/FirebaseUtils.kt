package com.learn.signupfirebase.ui.data.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

//uma task generia que pode ser usada para qualquem funcao
suspend fun <T> Task<T>.await():T{

    return suspendCancellableCoroutine {cont->
        addOnCompleteListener{
            if (it.exception!=null){
                cont.resumeWithException(it.exception!!)
            }else{
                cont.resume(it.result, null)
            }
        }
    }
}