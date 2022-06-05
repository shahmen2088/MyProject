package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.MainActivity;
import com.example.myproject.Model.Category;
import com.example.myproject.Model.Course;
import com.example.myproject.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    //Создаем адаптер и в качестве адаптера передаевм вложенный класс

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //на странице Создать держатель представления
        //Здесь создается то как должен наш объект отображатся пользователю

        //Какой конкретный дизайн будем использовать для отображения
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        //метод from - примает страницу на которой будет отображатся
        //метод inflate - 1. Дизайн, который мы будем использовать (Дизайн, который мы создали в layout
        // 2. Класс родитель (родительский объект передается в this метод)
        // 3. false означает, что мы не прикрепляем наш дизайн к родительскому классу

        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        //на держателе вида привязки
        //Описываем, что в каждое поле будем подставлять
        holder.categoryTitle.setText(categoryList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        //получить Количество элементов
        return categoryList.size();
    }
    public static final class CategoryViewHolder extends RecyclerView.ViewHolder{
        //В этом вложенном классе мы можем обратиться к определенному дизайну
        //Создание дизайна и вставка значений будет происходить здесь

        //Создаем поля с которыми мы будем взаимодействовать
        //На данном этапе будем использовать только текст
        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            //устанавливаем значение для текста
        }
    }
}
