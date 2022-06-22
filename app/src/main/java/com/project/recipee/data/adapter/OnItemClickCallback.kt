package com.project.recipee.data.adapter

import com.project.recipee.data.response.RandomResponse

interface OnItemClickCallback {
    fun onItemClicked(item : RandomResponse)
}