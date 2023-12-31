package com.example.dacn_cr424e_2324_thaibahung_0633.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dacn_cr424e_2324_thaibahung_0633.Model.Quiz;
import com.example.dacn_cr424e_2324_thaibahung_0633.R;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private List<Quiz> quizzes;
    private IQuizClicked iQuizClicked;
    public QuizAdapter(List<Quiz> quizzes, IQuizClicked iQuizClicked) {
        this.quizzes = quizzes;
        this.iQuizClicked = iQuizClicked;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);
        holder.itemView.setTag(position);
        holder.quiz_item_text.setText(String.valueOf(position + 1));
        if(quiz.getChooseAnswer() == 0)
            holder.quiz_item_image.setImageResource(R.drawable.quiz_item_not_answer);
        else
            holder.quiz_item_image.setImageResource(R.drawable.quiz_item_true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iQuizClicked.clickQuiz((int)(v.getTag()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return quizzes.size() ;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView quiz_item_image;
        private TextView quiz_item_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quiz_item_image = itemView.findViewById(R.id.quiz_item_image);
            quiz_item_text = itemView.findViewById(R.id.quiz_item_text);
        }
    }
}
