package com.example.projecthmti.ui.theme.Screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecthmti.R


data class ScheduleItem(
    val title: String,
    val pelaksana: String,
    val ruang: String,
    val jam: String
)


@Composable
fun ScheduleScreen(
    onBackClick: () -> Unit
) {

    val scheduleList = listOf(
        ScheduleItem("RAPAT PARIPURNA", "WINDAH BASUDARA", "A-14", "08.00 - 10.30"),
        ScheduleItem("RAPAT MBG", "PRAVRORO", "A-14", "08.00 - 10.30"),
        ScheduleItem("RAPAT BOCIL KEMATIAN", "ILHAM GOD", "A-14", "08.00 - 10.30"),
        ScheduleItem("RAPAT PARIPURNA", "WINDAH BASUDARA", "A-14", "08.00 - 10.30"),
        ScheduleItem("RAPAT MBG", "PRAVRORO", "A-14", "08.00 - 10.30"),
        ScheduleItem("RAPAT BOCIL KEMATIAN", "ILHAM GOD", "A-14", "08.00 - 10.30")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Tombol kembali
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Kembali ke Home",
                    tint = Color(0xFF00A9D6)
                )
            }

            Text(
                text = stringResource(R.string.Schedule),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                color = Color(0xFF00A9D6)
            )

            // Tombol-tombol aksi
            Row {
                IconButton(onClick = { /* Tambah Jadwal */ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Tambah Jadwal",
                        tint = Color(0xFF00A9D6)
                    )
                }

                IconButton(onClick = { /* Edit Jadwal */ }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Jadwal",
                        tint = Color(0xFF00A9D6)
                    )
                }

                IconButton(onClick = { /* Hapus Jadwal */ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Hapus Jadwal",
                        tint = Color(0xFF00A9D6)
                    )
                }
            }
        }

        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(scheduleList.size) { index ->
                ScheduleCard(scheduleList[index])
            }
        }


    }
}



@Composable
fun ScheduleCard(item: ScheduleItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.title,
                color = Color(0xFF00A9D6),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Pelaksana", fontWeight = FontWeight.SemiBold)
            Text(text = item.pelaksana.uppercase())
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Ruang", fontWeight = FontWeight.SemiBold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.lokasi),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = item.ruang)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "JAM", fontWeight = FontWeight.SemiBold)
            Text(text = item.jam)
        }
    }
}


