package com.example.myapplication.di

import com.example.myapplication.DataSource.*
import com.example.myapplication.Repository.*
import com.example.myapplication.UseCase.*
import com.example.myapplication.ViewModel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appmodule= module{
    single<RemoteNotebookDataSource> { RemoteNotebookDataSourceImpl() }
    single<NotebookRepository>{ NotebookRepositoryImpl(get()) }
    factory { LoadNotebookUseCase(get()) }

    single<RemoteAccessoryDataSource>{ RemoteAccessoryDataSourceImpl() }
    single<AccessoryRepository>{AccessoryRepositoryImpl(get())}
    factory{LoadAccessoryUseCase(get())}

    single<RemoteSmartphoneDataSource>{ RemoteSmartphoneDataSourceImpl() }
    single<SmartphoneRepository>{SmartphoneRepositoryImpl(get())}
    factory{LoadSmartphoneUseCase(get())}

    single<RemoteWireHeadphonesDataSource>{ RemoteWireHeadphonesDataSourceImpl() }
    single<WireHeadphonesRepository>{WireHeadphonesRepositoryImpl(get())}
    factory{LoadWireHeadphoneUseCase(get())}

    single<RemoteWirelessHeadphonesDataSource>{ RemoteWirelessHeadphonesDataSourceImpl() }
    single<WirelessHeadphoneRepository>{WirelessHeadphoneRepositoryImpl(get())}
    single{LoadWirelessHeadphoneUseCase(get())}

    viewModel {NotebookViewModel(get()) }
    viewModel {AccessoryViewModel(get())}
    viewModel{SmartphoneViewModel(get())}
    viewModel{WireHeadphonesViewModel(get())}
    viewModel{WirelessHeadphonesViewModel(get())}
}