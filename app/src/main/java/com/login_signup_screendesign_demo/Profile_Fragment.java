package com.login_signup_screendesign_demo;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_OK;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link Profile_Fragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link Profile_Fragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Profile_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static TextView tagline,Name,no1,no2,no3;

    LinearLayout ques_tab,ans_tab;

    final String TAG = "Image";

    final String ROOT_URL = "https://wwwqueriuscom.000webhostapp.com/";

    User_Info info;

    private  RoundedImageView imageView;

    ImageView iview;
    CameraPhoto cameraPhoto;

    final int CAMERA_REQUEST = 1990;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public Profile_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Profile_Fragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static Profile_Fragment newInstance(String param1, String param2) {
//        Profile_Fragment fragment = new Profile_Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        View v = inflater.inflate(R.layout.fragment_profile_, container, false);
        Intent i = getActivity().getIntent();
        info = (User_Info) i.getSerializableExtra("Com_object");
        if (info != null)
            Log.d(TAG, "At the beginning" + info.getQues_asked());

        tagline = (TextView) v.findViewById(R.id.tag);
        Name = (TextView) v.findViewById(R.id.name);
        imageView = (RoundedImageView) v.findViewById(R.id.logo);
        iview = (ImageView) v.findViewById(R.id.toggle);
        no1 = (TextView) v.findViewById(R.id.no1);
        no2 = (TextView) v.findViewById(R.id.no2);
        no3 = (TextView) v.findViewById(R.id.no3);
        ques_tab = (LinearLayout) v.findViewById(R.id.ques_tab);
        ans_tab = (LinearLayout) v.findViewById(R.id.all_answers);

        tagline.setText(info.getTagLine());
        Name.setText(info.getName());
        no1.setText(""+info.getQues_asked());
        no2.setText(""+info.getAns_given());
        no3.setText(""+info.getFollower());


        ques_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionProfile questionProfile = new QuestionProfile();
                Bundle bundle = new Bundle();
                bundle.putString("NAME",info.getName());
                bundle.putString("TAGLINE",info.getTagLine());
                bundle.putInt("USERID",info.getUser_id());
                questionProfile.setArguments(bundle);
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.content,questionProfile).commit();

            }
        });


        ans_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


//        iview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu dropDownMenu = new PopupMenu(Profile_Fragment.this.getActivity(), iview);
//                dropDownMenu.getMenuInflater().inflate(R.menu.menu_drop_down, dropDownMenu.getMenu());
//                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//
//                        switch (menuItem.getItemId()){
//                            case R.id.dropdown_menu1:
//                                onDestroy();
//
//                                FragmentManager fragmentManager = null;
//                                fragmentManager
//                                        .beginTransaction()
//                                        .replace(R.id.frameContainer, new Login_Fragment(),
//                                                Utils.Login_Fragment).commit();
//                                return true;
//                        }
//
////                        Toast.makeText(Profile_Fragment.this.getActivity(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                        return true;
//                    }
//                });
//                dropDownMenu.show();
//            }
//
//        });

//        Bitmap bitmap=null;
//        try {
//            bitmap = ImageLoader.init().from(info.getImageURL()).requestSize(80,80).getBitmap();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        imageView.setImageBitmap(bitmap);

//        if(info.getImageURL().equals("https://wwwqueriuscom.000webhostapp.com/index.jpg")){
//            Picasso.with(Profile_Fragment.this.getActivity()).load(info.getImageURL()).into(imageView);
//        }
//        else {
////            final ProviderInfo info = getContext().getPackageManager()
////                    .resolveContentProvider(authority, PackageManager.GET_META_DATA);
////            final XmlResourceParser in = info.loadXmlMetaData( //560
////                    getContext().getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
////            Bitmap btmp = Bitmap.createBitmap(drawable.getBitmap());
//            Picasso.with(Profile_Fragment.this.getActivity()).load(info.getImageURL()).into(imageView);
//
//
//
////            Uri uri = FileProvider.getUriForFile(getContext(), getContext().getApplicationContext().getPackageName() + ".fileprovider",file);
////            Log.d(TAG, "" + uri);
////            imageView.setImageURI(uri);
////            imageView.setImageBitmap(BitmapFactory.decodeFile(info.getImageURL()));
//        }
//        imageView.setImageBitmap(BitmapFactory.decodeFile());

        cameraPhoto = new CameraPhoto(Profile_Fragment.this.getContext());


                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            Log.d(TAG,"on click");
                            checkImagePermissions();
                    }
                });
        return v;
        }



//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }


    private void checkImagePermissions(){
        if(Build.VERSION.SDK_INT>=23){
            if(ActivityCompat.checkSelfPermission(Profile_Fragment.this.getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED   && ActivityCompat.checkSelfPermission(Profile_Fragment.this.getActivity(), Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG,"Inside checkImage");
                requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA},123);
                return;
            }
            else{
                Log.d(TAG,"Inside checkImage else part");
                try {
                    startActivityForResult(cameraPhoto.takePhotoIntent(), CAMERA_REQUEST);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cameraPhoto.addToGallery();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        Log.d(TAG,"Inside switch case");
                        try {
                            startActivityForResult(cameraPhoto.takePhotoIntent(), CAMERA_REQUEST);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        cameraPhoto.addToGallery();
                    }
                }else{
                    Toast.makeText(Profile_Fragment.this.getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    checkImagePermissions();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(resultCode == RESULT_OK){
                if(requestCode==CAMERA_REQUEST){
                    String photoPath = cameraPhoto.getPhotoPath();
                    Log.d(TAG,"Inside onActivityforresult"+photoPath);
                    try {
                        Bitmap bitmap = ImageLoader.init().from(photoPath).requestSize(80,80).getBitmap();
                        imageView.setImageBitmap(bitmap);
                       uploadImage(photoPath);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(Profile_Fragment.this.getActivity(),"Something Went Wrong Again",Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }


    public void uploadImage(final String photopath){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Image_interface imageInterface = retrofit.create(Image_interface.class);

        Call<Integer> call = imageInterface.uploadImage(info.getUser_id(),photopath);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int value = response.body();
                if(value==1){
                    Log.d(TAG,"set");
                    info.setImageURL(photopath);
                }
                else{
                    Log.d(TAG,"notset");
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.d(TAG,"Error");
                t.printStackTrace();


            }
        });
    }


//    @Override
//    public boolean onMenuItemClick(MenuItem menuItem) {
//        return false;
//    }
}
