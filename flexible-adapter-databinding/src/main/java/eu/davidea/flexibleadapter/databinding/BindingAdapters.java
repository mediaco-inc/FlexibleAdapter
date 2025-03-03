package eu.davidea.flexibleadapter.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class BindingAdapters {

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "items")
    public static <T extends IFlexible> void setAdapter(RecyclerView recyclerView, List<T> items) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && adapter instanceof FlexibleAdapter) {
            ((FlexibleAdapter<T>) adapter).updateDataSet(items, false);
        } else {
            throw new IllegalStateException("Binding works only with FlexibleAdapter");
        }
    }

}