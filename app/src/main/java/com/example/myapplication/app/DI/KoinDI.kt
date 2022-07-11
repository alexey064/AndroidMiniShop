package com.example.myapplication.app.DI

import com.example.myapplication.ViewModel.*
import com.example.myapplication.domain.datasource.*
import com.example.myapplication.domain.repositories.*
import com.example.myapplication.domain.usecases.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DImodule = module {

    single<GetMaxDiscountedUseCase>{GetMaxDiscountedUseCaseImpl(get())}
    single<GetMostBuyedUseCase>{GetMostBuyedUseCaseImpl(get())}
    single<GetNewlyAddedUseCase>{GetNewlyAddedUseCaseImpl(get())}
    single<GetAccessoryUseCase>{GetAccessoryUseCaseImpl(get())}
    single<GetNotebookUseCase>{GetNotebookUseCaseImpl(get())}
    single<GetSmartphoneUseCase>{GetSmartphoneUseCaseImpl(get())}
    single<GetWireHeadUseCase>{GetWireHeadUseCaseImpl(get())}
    single<GetWirelessHeadUseCase>{GetWirelessHeadUseCaseImpl(get())}

    single<MaxDiscountedRepository>{ MaxDiscountedRepositoryImpl(get()) }
    single<MostBuyedRepository>{MostBuyedRepositoryImpl(get())}
    single<NewlyAddedRepository>{NewlyAddedRepositoryImpl(get())}
    single<AccessoriesRepository>{AccessoryRepositoryImpl(get())}
    single<NotebookRepository>{NotebookRepositoryImpl(get())}
    single<SmartphoneRepository>{SmartphoneRepositoryImpl(get())}
    single<WireHeadRepository>{WireHeadRepositoryImpl(get())}
    single<WirelessHeadRepository>{WirelessHeadRepositoryImpl(get())}

    single<MaxDiscountedSource> { MaxDiscountedNetworkSource() }
    single<MostBuyedSource> {MostBuyedNetworkSource() }
    single<NewlyAddedSource>{NewlyAddedNetworkSource()}
    single<AccessoriesNetworkSource>{AccessoriesNetworkSourceImpl()}
    single<NotebookNetworkSource>{NotebookNetworkSourceImpl()}
    single<SmartphoneNetworkSource>{SmartphoneNetworkSourceImpl()}
    single<WireHeadNetworkSource>{WireHeadNetworkSourceImpl()}
    single<WirelessHeadNetworkSource>{WirelessHeadNetworkSourceImpl()}

    viewModel{MainPageViewModel(get(),get(),get())}
    viewModel{AccessoryViewModel(get())}
    viewModel{NotebookViewModel(get())}
    viewModel{SmartphoneViewModel(get())}
    viewModel{WireHeadphonesViewModel(get())}
    viewModel{WirelessHeadphonesViewModel(get())}
}