package com.example.cupcake.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.data.DataSource

@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier
    ){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.padding_small))
        ){
            Image(
                painter = painterResource(id = R.drawable.cupcake),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Text(
                text = stringResource(id = R.string.order_cupcakes),
                style = MaterialTheme.typography.bodyLarge
            )
            
        }
        Row(modifier = Modifier.weight(1f, false)){
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                quantityOptions.forEach{item ->
                    SelectQuantityButton(
                        labelResourceId = item.first,
                        onClick = {})
                }
            }
        }
        
    }
}

@Composable
fun SelectQuantityButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = Modifier.widthIn(min = 250.dp)
    ){
        Text(text = stringResource(labelResourceId))
    }
}

@Preview
@Composable
fun StartOrderPreview(){
    StartOrderScreen(
        quantityOptions = DataSource.quantityOptions,
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
        )
}