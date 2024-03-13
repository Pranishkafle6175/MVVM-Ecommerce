package com.loc.androidarchitecturesample.store.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.Modifier



@Composable
fun LoadingDialog(){

    Dialog(onDismissRequest = { /*TODO*/ }) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}