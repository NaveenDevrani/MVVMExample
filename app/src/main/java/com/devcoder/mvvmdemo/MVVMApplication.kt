package com.devcoder.mvvmdemo

import android.app.Application
import com.devcoder.mvvmdemo.data.network.ApiService
import com.devcoder.mvvmdemo.data.network.NetworkConnectionInterceptor
import com.devcoder.mvvmdemo.data.repository.UserRepository
import com.devcoder.mvvmdemo.ui.auth.AuthViewModlFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModlFactory(instance()) }
    }
}