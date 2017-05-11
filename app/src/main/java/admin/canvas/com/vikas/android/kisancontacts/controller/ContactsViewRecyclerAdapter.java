package admin.canvas.com.vikas.android.kisancontacts.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import admin.canvas.com.vikas.android.kisancontacts.R;
import admin.canvas.com.vikas.android.kisancontacts.model.ContactsModel;

/**
 * Created by vikas on 5/10/2017.
 */

public class ContactsViewRecyclerAdapter extends RecyclerView.Adapter<ContactsViewRecyclerAdapter.ViewHolder> {
    private List<ContactsModel> contactsModels;
    private OnClickListener onclickListener;

    public ContactsViewRecyclerAdapter(List<ContactsModel> contactsModels) {
        this.contactsModels = contactsModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_contacts_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ContactsModel contactsModel = contactsModels.get(position);
        holder.textViewImage.setText(String.valueOf(contactsModel.getFirstName().charAt(0)));
        holder.textViewName.setText(contactsModel.getFirstName() + " " + contactsModel.getLastName());
    }

    @Override
    public int getItemCount() {
        return contactsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewImage, textViewName;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewImage = (TextView) itemView.findViewById(R.id.tvContactsImage);
            textViewName = (TextView) itemView.findViewById(R.id.tvContactsName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onclickListener.onClick(getAdapterPosition());
        }
    }

    public void setClickListener(OnClickListener clickListener) {
        this.onclickListener = clickListener;
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
