package be.ben.tinkin.view;

import be.ben.tinkin.Fact;
import be.ben.tinkin.provider.FactProvider;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Benoit Dupont
 */
@Route
public class MainView extends VerticalLayout {
    final Grid<Fact> grid;
    private FactProvider provider;

    public MainView(@Qualifier("memoryFactProvider") FactProvider provider) {
        this.provider = provider;
        this.grid = new Grid<>(Fact.class);
        add(grid);

        populateGrid();
    }

    private void populateGrid() {
        this.grid.setItems(provider.getFacts());
    }


}

