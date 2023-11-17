package com.example.trabajaya.utils.navegation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trabajaya.R
import com.example.trabajaya.data.remote.dto.EmpleoDto
import com.example.trabajaya.ui.viewModel.EmpleoViewModel
import com.example.trabajaya.utils.directionModule.ScreenDirectionModule
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Todo: Direño del menu. Este contiene las direcciones establecidas en el ScreenDirectionModule que serviran como entrada a la pantalla/s deseada/s a ingresar.

// Todo: Nota: Para tener mas control en relacion a la movilidad de las opciones en el contorno del 'ModalNavigationDrawer', se agrego un 'NavigationDrawerItem' y 'items'.

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawerMenu(navController: NavController, empleoViewModel: EmpleoViewModel = viewModel()) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val item_1 = listOf(
        ScreenDirectionModule.PMain
    )
    val item_2 = listOf(
        ScreenDirectionModule.P2
    )
    val item_3 = listOf(
        ScreenDirectionModule.P1
    )
    val item_4 = listOf(
        ScreenDirectionModule.P3
    )
    val item_5 = listOf(
        ScreenDirectionModule.Pconfig
    )

    val selectedItem_1 = remember { mutableStateOf(item_1[0]) }
    val selectedItem_2 = remember { mutableStateOf(item_2[0]) }
    val selectedItem_3 = remember { mutableStateOf(item_3[0]) }
    val selectedItem_4 = remember { mutableStateOf(item_4[0]) }
    val selectedItem_5 = remember { mutableStateOf(item_5[0]) }

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Spacer(Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(resourceId = R.drawable.logo)
            }
            Divider(
                modifier = Modifier.fillMaxWidth(), color = Color.Gray
            )
            Spacer(Modifier.height(15.dp))
            item_1.forEach { item ->
                NavigationDrawerItem(icon = {
                    if (item.icon is Int) {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    } else {
                        Icon(Icons.Default.Warning, contentDescription = null)
                    }
                },
                    label = { Text(item.title, fontSize = 16.sp, color = Color.Black) },
                    selected = item == selectedItem_1.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem_1.value = item
                        navController.navigate(item.route)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            item_2.forEach { item ->
                NavigationDrawerItem(icon = {
                    if (item.icon is Int) {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    } else {
                        Icon(Icons.Default.Warning, contentDescription = null)
                    }
                },
                    label = { Text(item.title, fontSize = 16.sp, color = Color.Black) },
                    selected = item == selectedItem_2.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem_2.value = item
                        navController.navigate(item.route)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            item_3.forEach { item ->
                NavigationDrawerItem(icon = {
                    if (item.icon is Int) {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    } else {
                        Icon(Icons.Default.Warning, contentDescription = null)
                    }
                },
                    label = { Text(item.title, fontSize = 16.sp, color = Color.Black) },
                    selected = item == selectedItem_3.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem_3.value = item
                        navController.navigate(item.route)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            item_4.forEach { item ->
                NavigationDrawerItem(icon = {
                    if (item.icon is Int) {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    } else {
                        Icon(Icons.Default.Warning, contentDescription = null)
                    }
                },
                    label = { Text(item.title, fontSize = 16.sp, color = Color.Black) },
                    selected = item == selectedItem_4.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem_4.value = item
                        navController.navigate(item.route)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            item_5.forEach { item ->
                NavigationDrawerItem(icon = {
                    if (item.icon is Int) {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    } else {
                        Icon(Icons.Default.Warning, contentDescription = null)
                    }
                },
                    label = { Text(item.title, fontSize = 16.sp, color = Color.Black) },
                    selected = item == selectedItem_5.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem_5.value = item
                        navController.navigate(item.route)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }, content = {
        Column(
            modifier = Modifier
                .size(200.dp, 200.dp)
                .padding(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Icon(imageVector = Icons.Filled.List,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .padding(4.dp)
                    .clickable {
                        scope.launch { drawerState.open() }
                    })
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PantallaInicial(empleoViewModel)
        }
    })
}

@Composable
fun CustomIcon(resourceId: Int) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = null,
        colorFilter = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(300.dp, 300.dp)
    )
}


//pantalla principal
@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaInicial(empleoViewModel: EmpleoViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    val uiState by empleoViewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "TrabajaYA - Empleos recientes:",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EmpleoDetails(empleoList = uiState.empleos)

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EmpleoDetails(empleoList: List<EmpleoDto>) {
    LazyColumn {
        items(empleoList) { empleo ->
            val fechaParseada =
                LocalDateTime.parse(empleo.fechaDePublicacion, DateTimeFormatter.ISO_DATE_TIME)
            val fechaFormateada = fechaParseada.format(DateTimeFormatter.ISO_DATE)
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.background
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("${empleo.nombre} - ${empleo.categoria}", style = MaterialTheme.typography.labelLarge)
                        Text(
                            "${empleo.descripcion}",
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(Color.Gray.copy(alpha = 0.2f))
                                .padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Publicado el: $fechaFormateada en ${empleo.provincia}",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color = Color.Gray)
        }
    }
}
