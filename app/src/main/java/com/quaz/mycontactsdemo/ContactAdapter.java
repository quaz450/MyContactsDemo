package com.quaz.mycontactsdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends ListAdapter<Contact, ContactAdapter.ContactHolder> {

    private OnItemClickListener listener;

    public ContactAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Contact> DIFF_CALLBACK = new DiffUtil.ItemCallback<Contact>() {
        @Override
        public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.getFistName().equals(newItem.getFistName()) &&
                    oldItem.getLastName().equals(newItem.getLastName()) &&
                    oldItem.getEmail().equals(newItem.getEmail()) &&
                    oldItem.getPhoneNumber().equals(newItem.getPhoneNumber());

        }
    };

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact currentContact = getItem(position);
        holder.tv_firstName.setText(currentContact.getFistName());
        holder.tv_lastName.setText(currentContact.getLastName());
        holder.tv_email.setText(currentContact.getEmail());
        holder.tv_phoneNumber.setText(currentContact.getPhoneNumber());


    }

    public Contact getContactAt(int position){
        return getItem(position);
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        private ImageView iv_image;
        private TextView tv_firstName;
        private TextView tv_lastName;
        private TextView tv_email;
        private TextView tv_phoneNumber;

        public ContactHolder(View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_contact_image);
            tv_firstName = itemView.findViewById(R.id.tv_first_name);
            tv_lastName = itemView.findViewById(R.id.tv_last_name);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_phoneNumber = itemView.findViewById(R.id.tv_phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }


    }
    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
