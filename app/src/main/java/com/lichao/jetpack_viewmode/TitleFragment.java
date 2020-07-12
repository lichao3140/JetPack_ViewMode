package com.lichao.jetpack_viewmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.lichao.jetpack_viewmode.databinding.FragmentTitleBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {

    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        FragmentTitleBinding binding;

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        // 进入Question页面
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_title, container, false);
    }
}
