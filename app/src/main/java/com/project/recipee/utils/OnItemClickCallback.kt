package com.project.recipee.utils

import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem

interface OnItemClickCallback {
    fun onItemClicked(item: RandomResponseItem)
}