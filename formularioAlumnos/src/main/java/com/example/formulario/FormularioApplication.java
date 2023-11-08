package com.example.formulario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
@Controller
public class FormularioApplication {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
   
    @GetMapping("/")
    public String index (Model model, @PageableDefault(size=5) Pageable p){
        Page<Alumno> alumnos = alumnoRepository.findAll(p);
        //List<Alumno> alumnos = alumnoRepository.findAll();
        model.addAttribute("alumnos", alumnos);
        
        return "index";    
    }
    
    @GetMapping("/nuevoAlumno")
    public String nuevo (Model model){
        model.addAttribute("alumno", new Alumno());
        return "nuevoAlumno";
    }
    
    
    
@GetMapping("/editar")
    public String update(Model model, @RequestParam(value="id") String id) {
        Optional<Alumno> alumno = alumnoRepository.findById(Integer.valueOf(id));
        model.addAttribute("alumno", alumno);
        return "editar";
    }
    
      
    
    
    @PostMapping("/eliminar-alumno")
    public String borrarAlumno (@RequestParam int id){
        alumnoRepository.deleteById(id);
        return "redirect:/";   
    }
    
 
  @PostMapping("/editar")
            public String update(Alumno a) {
    //public String update(@PathVariable int id, @ModelAttribute Alumno alumnoActualizado) {
       // Optional<Alumno> alumnoExistente = alumnoRepository.findById(id);
        //alumnoExistente.ifPresent(value->alumnorepository.save(value));
        
     /*   if (alumnoExistente.isPresent()) {
           Alumno alumno = alumnoExistente.get();
            alumno.setNombre(a.getNombre());
            alumno.setApellidos(a.getApellidos());
            alumno.setEdad(a.getEdad());
            alumno.setDni(a.getDni());
            alumnoRepository.save(alumno);
        }*/
     alumnoRepository.save(a);
        return "redirect:/";
    }

    
    
    
    
    
    @PostMapping("/nuevoAlumno")
    public String crear (Alumno alumno){
        alumnoRepository.save(alumno);
        return "redirect:/";
    }
    
    
    

        
	public static void main(String[] args) {
		SpringApplication.run(FormularioApplication.class, args);
	}
        
         @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

}
