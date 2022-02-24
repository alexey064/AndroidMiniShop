package com.example.myapplication.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentProductBinding;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Objects;

import Models.LoginData;
import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment{

    /*private FragmentProductBinding binding;
    ProductViewModel viewModel;
    View root;
    LayoutInflater inflat;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        inflat=inflater;
        int id = Integer.parseInt(getArguments().getString("id"));
        viewModel = new ViewModelProvider(this, new ProductViewModel.MyViewModelFactory(id)).get(ProductViewModel.class);
        viewModel.GetProduct().observe((LifecycleOwner) this, updateProduct);
        return root;
    }
    Observer<Product> updateProduct = new Observer<Product>() {
        @Override
        public void onChanged(Product product) {

            TextView name = root.findViewById(R.id.Product_name);
            TextView description = root.findViewById(R.id.Product_description);
            Button buy = root.findViewById(R.id.ProductBuy);
            ImageView img = root.findViewById(R.id.Product_img);
            View AddInfo=null;
            if (product.getNotebook()!=null)
            {
                AddInfo = inflat.inflate(R.layout.detail_notebook, null);
                AddInfo=getNotebookDetail(AddInfo, product);
            }
            if (product.getSmartphone()!=null)
            {
                AddInfo = inflat.inflate(R.layout.detail_smartphone, null);
                AddInfo=getSmartphoneDetail(AddInfo, product);
            }
            if (product.getWirelessHeadphones()!=null)
            {
                AddInfo = inflat.inflate(R.layout.detail_wirelessheadphones, null);
                AddInfo=getWirelessHeadphonesDetail(AddInfo, product);
            }
            if (product.getWireHeadphones()!=null)
            {
                AddInfo = inflat.inflate(R.layout.detail_wireheadphones, null);
                AddInfo=getWireHeadphones(AddInfo, product);
            }
            View CommonInfo = inflat.inflate(R.layout.detail_common, null);
            TextView TypeValue = CommonInfo.findViewById(R.id.TypeValue);
            TypeValue.setText(product.getType().getCategory());
            TextView BrandValue = CommonInfo.findViewById(R.id.BrandValue);
            BrandValue.setText(product.getBrand().getName());
            TextView ColorValue = CommonInfo.findViewById(R.id.ColorValue);
            ColorValue.setText(product.getColor().getName());
            FrameLayout FAddInfo = root.findViewById(R.id.InfoDetailed);
            FrameLayout FCommonInfo = root.findViewById(R.id.InfoCommon);
            if (AddInfo!=null)    FAddInfo.addView(AddInfo);
            FCommonInfo.addView(CommonInfo);
            //value.setLayoutParams(weight);
            String url = product.getPhoto();
            try{
                Picasso.get() // Context
                        .load("http://192.168.1.180:82"+url) // URL or file
                        .into(img);
                buy.setText(String.valueOf(product.getPrice()));
                buy.setOnClickListener(BuyClick);
                description.setText(product.getDescription());
                name.setText(product.getName());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    View.OnClickListener BuyClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            HashMap<String, Integer> data = new HashMap<String, Integer>();
            data.put("id",Integer.valueOf(getArguments().getString("id")));
            if (LoginData.getUsername()!=null)
                NetworkService.getInstance().getApi().PostSHoppingCart(data).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (!response.body().equals("true"))
                        {
                            Toast.makeText(getContext(), R.string.CartAddFailed, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getContext(), R.string.CartAddFailed, Toast.LENGTH_SHORT).show();
                            Bundle bundle = new Bundle();
                            bundle.putString("id",getArguments().getString("id"));
                            Navigation.findNavController(view).navigate(R.id.productFragment, bundle);
                        }
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            else Toast.makeText(getContext(), R.string.SignInRequired,Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
    public View getNotebookDetail(View AddInfo, Product product)
    {
        TextView RamCountValue = AddInfo.findViewById(R.id.RamCountValue);
        RamCountValue.setText(String.valueOf(product.getNotebook().getRAMCount()));

        TextView WeightValue = AddInfo.findViewById(R.id.WeightValue);
        WeightValue.setText(String.valueOf(product.getNotebook().getWeight()));

        TextView HDDSizeValue = AddInfo.findViewById(R.id.HDDSizeValue);
        HDDSizeValue.setText(String.valueOf(product.getNotebook().getHDDSize()));

        TextView SSDSizeValue = AddInfo.findViewById(R.id.SSDSizeValue);
        SSDSizeValue.setText(String.valueOf(product.getNotebook().getSSDSize()));

        TextView ScreenSizeValue = AddInfo.findViewById(R.id.ScreenSizeValue);
        ScreenSizeValue.setText(String.valueOf(product.getNotebook().getScreenSize()));

        TextView ScreenResolutionValue = AddInfo.findViewById(R.id.ScreenResolutionValue);
        ScreenResolutionValue.setText(product.getNotebook().getScreenResolution());

        TextView CameraValue = AddInfo.findViewById(R.id.CameraValue);
        CameraValue.setText(product.getNotebook().getCamera());

        TextView WirelessCommunicationValue = AddInfo.findViewById(R.id.WirelessCommunicationValue);
        WirelessCommunicationValue.setText(product.getNotebook().getWirelessCommunication());

        TextView BatteryCapacityValue = AddInfo.findViewById(R.id.BatteryCapacityValue);
        BatteryCapacityValue.setText(String.valueOf(product.getNotebook().getBatteryCapacity()));

        TextView OutputsValue = AddInfo.findViewById(R.id.OutputsValue);
        OutputsValue.setText(product.getNotebook().getOutputs());

        TextView OptionalValue = AddInfo.findViewById(R.id.OptionalValue);
        OptionalValue.setText(product.getNotebook().getOptional());

        TextView OSValue = AddInfo.findViewById(R.id.OSValue);
        OSValue.setText(product.getNotebook().getOS().getName());

        TextView VieocardValue = AddInfo.findViewById(R.id.VideocardValue);
        VieocardValue.setText(product.getNotebook().getVideocard().getName());

        TextView ProcessorValue = AddInfo.findViewById(R.id.ProcessorValue);
        ProcessorValue.setText(product.getNotebook().getProcessor().getName());

        TextView ScreenTypeValue = AddInfo.findViewById(R.id.ScreenTypeValue);
        ScreenTypeValue.setText(product.getNotebook().getScreenType().getName());
        return AddInfo;
    }
    public View getSmartphoneDetail(View view, Product product)
    {
        TextView MemoryCountValue = view.findViewById(R.id.MemoryCountValue);
        MemoryCountValue.setText(String.valueOf(product.getSmartphone().getMemoryCount()));

        TextView RamCountValue = view.findViewById(R.id.RamCountValue);
        RamCountValue.setText(String.valueOf(product.getSmartphone().getRAMCount()));

        TextView BatteryCapacityValue = view.findViewById(R.id.BatteryCapacityValue);
        BatteryCapacityValue.setText(String.valueOf(product.getSmartphone().getBatteryCapacity()));

        TextView CameraValue = view.findViewById(R.id.CameraValue);
        CameraValue.setText(String.valueOf(product.getSmartphone().getCamera()));

        TextView PhoneSizeValue = view.findViewById(R.id.PhoneSizeValue);
        PhoneSizeValue.setText(String.valueOf(product.getSmartphone().getPhoneSize()));

        TextView WeightValue = view.findViewById(R.id.WeightValue);
        WeightValue.setText(String.valueOf(product.getSmartphone().getWeight()));

        TextView NFCValue = view.findViewById(R.id.NFCValue);
        NFCValue.setText(String.valueOf(product.getSmartphone().isNFC()));

        TextView CommunicationValue = view.findViewById(R.id.CommunicationValue);
        CommunicationValue.setText(String.valueOf(product.getSmartphone().getCommunication()));

        TextView ScreenSizeValue = view.findViewById(R.id.ScreenSizeValue);
        ScreenSizeValue.setText(String.valueOf(product.getSmartphone().getScreenSize()));

        TextView OptionalValue = view.findViewById(R.id.OptionalValue);
        OptionalValue.setText(String.valueOf(product.getSmartphone().getOptional()));

        TextView ScreenResolutionValue = view.findViewById(R.id.ScreenResolutionValue);
        ScreenResolutionValue.setText(String.valueOf(product.getSmartphone().getScreenResolution()));

        TextView OSValue = view.findViewById(R.id.OSValue);
        OSValue.setText(String.valueOf(product.getSmartphone().getOS().getName()));

        TextView ProcessorValue = view.findViewById(R.id.ProcessorValue);
        ProcessorValue.setText(String.valueOf(product.getSmartphone().getProcessor().getName()));

        TextView ScreenTypeValue = view.findViewById(R.id.ScreenTypeValue);
        ScreenTypeValue.setText(String.valueOf(product.getSmartphone().getScreenType().getName()));

        TextView ChargingTypeValue = view.findViewById(R.id.ChargingTypeValue);
        ChargingTypeValue.setText(String.valueOf(product.getSmartphone().getChargingType().getName()));

        return view;
    }
    public View getWirelessHeadphonesDetail(View view, Product product)
    {
        TextView RadiusValue = view.findViewById(R.id.RadiusValue);
        RadiusValue.setText(String.valueOf(product.getWirelessHeadphones().getRadius()));

        TextView BatteryValue = view.findViewById(R.id.BatteryValue);
        BatteryValue.setText(String.valueOf(product.getWirelessHeadphones().getBattery()));

        TextView CaseBattery = view.findViewById(R.id.CaseBatteryValue);
        CaseBattery.setText(String.valueOf(product.getWirelessHeadphones().getCaseBattery()));

        TextView ChargingType = view.findViewById(R.id.ChargingTypeValue);
        ChargingType.setText(String.valueOf(product.getWirelessHeadphones().getChargingType().getName()));

        return view;
    }
    public View getWireHeadphones(View view, Product product)
    {
        TextView WireLength = view.findViewById(R.id.WireLengthValue);
        WireLength.setText(String.valueOf(product.getWireHeadphones().getWireLenght()));

        TextView ConnectionType = view.findViewById(R.id.ConnectionTypeValue);
        ConnectionType.setText(product.getWireHeadphones().getConnectionType().getName());
        return view;
    }
     */
}