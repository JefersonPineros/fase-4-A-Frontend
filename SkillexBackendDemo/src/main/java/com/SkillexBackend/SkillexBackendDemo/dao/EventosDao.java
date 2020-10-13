
package com.SkillexBackend.SkillexBackendDemo.dao;

import com.SkillexBackend.SkillexBackendDemo.models.Eventos;
import com.SkillexBackend.SkillexBackendDemo.vo.EventosVO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventosDao {
    
    public List<EventosVO> mostrar_eventos();
    public Page<Eventos> findAll(Pageable pageable);
    public Object save(EventosVO evento);
    public Object deleteById(EventosVO borrar);
    public Object updateEvento(EventosVO evento);
        
}
