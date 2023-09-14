package com.narcis.presentation.viewModel.event

sealed class RandomGifEvent {
    data class AutoTrigger(val load: Boolean) : RandomGifEvent()
}
