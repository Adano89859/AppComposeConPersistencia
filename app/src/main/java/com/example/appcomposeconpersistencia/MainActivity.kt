package com.example.appcomposeconpersistencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcomposeconpersistencia.modelo.BaseDatos
import com.example.appcomposeconpersistencia.modelo.NotaRepository
import com.example.appcomposeconpersistencia.ui.theme.AppComposeConPersistenciaTheme
import com.example.appcomposeconpersistencia.vista.NotasScreen
import com.example.appcomposeconpersistencia.vistaModelo.NotasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Invoco las variables de todo cuanto se trabajó en otras carpetas para poder usarlo aquí
        val baseDatos = BaseDatos.create(applicationContext)
        val repositorioNotas = NotaRepository(baseDatos.notaDao())
        val modeloVista = NotasViewModel(repositorioNotas)

        setContent {
            MaterialTheme {
                //Aquí muestro el contenido en la pantalla, y para que se pueda usar
                NotasScreen(modeloVista)
            }
        }
    }
}