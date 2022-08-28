package app.trian.tes.component.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun LazyListScope.gridItems(
    count:Int,
    columnCount:Int,
    horizontalArrangement: Arrangement.Horizontal= Arrangement.Start,
    itemContent:@Composable BoxScope.(Int)->Unit

){
    gridItems(
        data = List(count){it},
        columnCount=columnCount,
        horizontalArrangement = horizontalArrangement,
        itemContent = itemContent,
    )
}

fun <T> LazyListScope.gridItems(
    data:List<T>,
    columnCount:Int,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent:@Composable BoxScope.(T)->Unit
){
    val rows = if(data.count() ==0) 0 else 1+(data.count() - 1) / columnCount
    items(rows){
            rowIndex->
        Row(horizontalArrangement = horizontalArrangement) {
            for(columnIndex in 0 until columnCount){
                val itemIndex = rowIndex*columnCount+columnIndex
                if(itemIndex < data.count()){
                    Box(
                        modifier = Modifier.weight(1f, fill = true),
                        propagateMinConstraints = true
                    ) {
                        itemContent.invoke(this,data[itemIndex])
                    }
                }else{
                    Spacer(Modifier.weight(1f, fill = true))
                }
            }
        }
    }
}