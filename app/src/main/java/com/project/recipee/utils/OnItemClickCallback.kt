package com.project.recipee.utils

import com.project.recipee.data.response.RandomResponse

interface OnItemClickCallback {
    fun onItemClicked(item: RandomResponse)
}