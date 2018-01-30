package com.uniagustiniana.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniagustiniana.tecnologias.uniagustapp.adaptadores.DirectorioAdapter;
import com.uniagustiniana.tecnologias.uniagustapp.clases.PersonajeVo;

import com.uniagustiniana.tecnologias.uniagustapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Directorio extends Fragment {


    RecyclerView recyclerPersonajes;
    ArrayList<PersonajeVo> listaPersonaje;

    public Fragment_Directorio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_directorio, container, false);

        listaPersonaje=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getActivity()));

        llenarLista();

        DirectorioAdapter adapter=new DirectorioAdapter(listaPersonaje);
        recyclerPersonajes.setAdapter(adapter);

        return vista;
    }

    private void llenarLista() {
        listaPersonaje.add(new PersonajeVo("Conmutador: 4193200","Recepcion principal Ext. 1002\nRecepción Académica Ext. 1001                                   ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Admisiones","Ext. 1054, 1108\nauxadmisiones@uniagustiniana.edu.co, admisiones@uniagustiniana.edu.co                  ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Administración de Empresas","Ext. 1133, 1062\nadmonempresas@uniagustiniana.edu.co asis.administracion@uniagustiniana.edu.co        ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Bienestar Institucional","Ext. 1095\nanalistabienestar@uniagustiniana.edu.co                                                        ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("CALEX","Centro Agustiniano de Lenguas extranjeras\nExt. 1115\nasiscalex@uniagustiniana.edu.co                                        ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("CEDEA","Centro de Emprendimiento Agustininano\nExt. 1110\nasis.emprendimiento@uniagustiniana.edu.co                                   ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Deportes y Actividad Física","Una breve descripción                                                                  ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("CETA","Centro de Estudios tecnológicos Agustinianos\nExt. 1123\nceta.cursos@uniagustiniana.edu.co ceta@uniagustiniana.edu.co            ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Ciencias Básicas","Ext. 1071\ncbasicas@uniagustiniana.edu.co                                                                          ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Cine y Televisión","Ext. 1063\ncineytv@uniagustiniana.edu.co                                                                          ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Comunicaciones","Ext. 1151\ncomunicaciones@uniagustiniana.edu.co                                                                      ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Contaduría Pública","Ext. 1050, 1032\nasis.contaduria@uniagustiniana.edu.co contaduria@uniagustiniana.edu.co                          ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Egresados","Ext. 1038\negresados@uniagustiniana.edu.co                                                                            ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Espiritualidad Agustiniana","Ext. 1135\nanalista.espiritualidad@uniagustiniana.edu.co                                             ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Facultad de Artes y Arquitectura","Ext. 1129, 1056\nasis.faa@uniagustiniana.edu.co                                                 ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Facultad de Ciencias Económicas y Administrativas","Ext. 1049\nasis.posgrados@uniagustiniana.edu.co                               ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Facultad de Ingenierías","Ext. 1128, 1052\nasis.industrial@uniagustiniana.edu.co                                                 ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Hotelería y Turismo","Ext. 1102, 1044\nasis.hoteleria@uniagustiniana.edu.co                                                       ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Ingeniería en Telecomunicaciones","Ext. 1057\ntelecomunicaciones@uniagustiniana.edu.co                                            ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Licenciatura en Folosofía","Ext. 1084\nfilosofía@uniagustiniana.edu.co                                                             ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Licenciatura en Teología","Ext. 1143\nlic.teologia@uniagustiniana.edu.co                                                           ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Mercadeo","Ext. 1021\nmercadeo@uniagustiniana.edu.co                                                                               ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Negocios Internacionales","Ext. 1079, 1051\nasis.negocios@uniagustiniana.edu.co                                                    ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("ORI","Oficina de Relaciones Internacionales\nExt. 1078\nasistente.ori@uniagustiniana.edu.co                                         ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Sede Suba","Ext. 2002, 2004\nasisadmonsuba@uniagustiniana.edu.co                                                                     ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Tecnología Desarrollo de Software","Ext. 1057\ndesarrollodesoftware@uniagustiniana.edu.co                                            ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Tecnología en Gastronomía","Ext. 1140, 1046\nasis.gastronomia@uniagustiniana.edu.co                                                   ",R.mipmap.ic_launcher));
        listaPersonaje.add(new PersonajeVo("Vicerrectoría Académica","Ext. 1048\nasistente.vice-academica@uniagustiniana.edu.co                                                   ",R.mipmap.ic_launcher));

    }

    public interface OnFragmentInteractionListener {
    }
}
