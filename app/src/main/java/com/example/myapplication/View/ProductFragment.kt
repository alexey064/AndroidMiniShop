package com.example.myapplication.View

import androidx.navigation.Navigation.findNavController
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import Models.LoginData
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.NetworkService
import com.example.myapplication.ViewModel.ProductViewModel
import com.example.myapplication.databinding.FragmentProductBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.HashMap

class ProductFragment : Fragment() {
    private var binding: FragmentProductBinding? = null
    var viewModel: ProductViewModel? = null
    var root: View? = null
    var inflat: LayoutInflater? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        root = binding!!.root
        inflat = inflater
        val id = arguments!!.getString("id")!!.toInt()
        viewModel =
            ViewModelProvider(this, ProductViewModel.MyViewModelFactory(id)).get(ProductViewModel::class.java)
        viewModel!!.GetProduct().observe(this as LifecycleOwner, updateProduct)
        return root
    }

    var updateProduct = Observer<Product?> { product ->
        val name = root!!.findViewById<TextView>(R.id.Product_name)
        val description = root!!.findViewById<TextView>(R.id.Product_description)
        val buy = root!!.findViewById<Button>(R.id.ProductBuy)
        val img = root!!.findViewById<ImageView>(R.id.Product_img)
        var AddInfo: View? = null
        if (product.notebook != null) {
            AddInfo = inflat!!.inflate(R.layout.detail_notebook, null)
            AddInfo = getNotebookDetail(AddInfo, product)
        }
        if (product.smartphone != null) {
            AddInfo = inflat!!.inflate(R.layout.detail_smartphone, null)
            AddInfo = getSmartphoneDetail(AddInfo, product)
        }
        if (product.wirelessHeadphones != null) {
            AddInfo = inflat!!.inflate(R.layout.detail_wirelessheadphones, null)
            AddInfo = getWirelessHeadphonesDetail(AddInfo, product)
        }
        if (product.wireHeadphones != null) {
            AddInfo = inflat!!.inflate(R.layout.detail_wireheadphones, null)
            AddInfo = getWireHeadphones(AddInfo, product)
        }
        val CommonInfo = inflat!!.inflate(R.layout.detail_common, null)
        val TypeValue = CommonInfo.findViewById<TextView>(R.id.TypeValue)
        TypeValue.text = product.type.category
        val BrandValue = CommonInfo.findViewById<TextView>(R.id.BrandValue)
        BrandValue.text = product.brand.name
        val ColorValue = CommonInfo.findViewById<TextView>(R.id.ColorValue)
        ColorValue.text = product.color.name
        val FAddInfo = root!!.findViewById<FrameLayout>(R.id.InfoDetailed)
        val FCommonInfo = root!!.findViewById<FrameLayout>(R.id.InfoCommon)
        if (AddInfo != null) FAddInfo.addView(AddInfo)
        FCommonInfo.addView(CommonInfo)
        //value.setLayoutParams(weight);
        val url = product.photo
        try {
            Picasso.get() // Context
                .load("http://192.168.1.180:82$url") // URL or file
                .into(img)
            buy.text = product.price.toString()
            buy.setOnClickListener(BuyClick)
            description.text = product.description
            name.text = product.name
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    var BuyClick = View.OnClickListener { view ->
        val data = HashMap<String, Int>()
        data["id"] = Integer.valueOf(arguments!!.getString("id"))
        GlobalScope.launch {
            if (LoginData.getUsername() != null)
            { val response = NetworkService.instance?.api?.PostSHoppingCart(data)
            if (response!!.body() != "true") {
                Toast.makeText(context, R.string.CartAddFailed, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, R.string.CartAddFailed, Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putString("id", arguments!!.getString("id"))
                findNavController(view).navigate(R.id.productFragment, bundle)
            }
        } else Toast.makeText(context, R.string.SignInRequired, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun getNotebookDetail(AddInfo: View?, product: Product): View? {
        val RamCountValue = AddInfo!!.findViewById<TextView>(R.id.RamCountValue)
        RamCountValue.text = product.notebook.ramCount.toString()
        val WeightValue = AddInfo.findViewById<TextView>(R.id.WeightValue)
        WeightValue.text = product.notebook.weight.toString()
        val HDDSizeValue = AddInfo.findViewById<TextView>(R.id.HDDSizeValue)
        HDDSizeValue.text = product.notebook.hddSize.toString()
        val SSDSizeValue = AddInfo.findViewById<TextView>(R.id.SSDSizeValue)
        SSDSizeValue.text = product.notebook.ssdSize.toString()
        val ScreenSizeValue = AddInfo.findViewById<TextView>(R.id.ScreenSizeValue)
        ScreenSizeValue.text = product.notebook.screenSize.toString()
        val ScreenResolutionValue = AddInfo.findViewById<TextView>(R.id.ScreenResolutionValue)
        ScreenResolutionValue.text = product.notebook.screenResolution
        val CameraValue = AddInfo.findViewById<TextView>(R.id.CameraValue)
        CameraValue.text = product.notebook.camera
        val WirelessCommunicationValue =
            AddInfo.findViewById<TextView>(R.id.WirelessCommunicationValue)
        WirelessCommunicationValue.text = product.notebook.wirelessCommunication
        val BatteryCapacityValue = AddInfo.findViewById<TextView>(R.id.BatteryCapacityValue)
        BatteryCapacityValue.text = product.notebook.batteryCapacity.toString()
        val OutputsValue = AddInfo.findViewById<TextView>(R.id.OutputsValue)
        OutputsValue.text = product.notebook.outputs
        val OptionalValue = AddInfo.findViewById<TextView>(R.id.OptionalValue)
        OptionalValue.text = product.notebook.optional
        val OSValue = AddInfo.findViewById<TextView>(R.id.OSValue)
        OSValue.text = product.notebook.os.name
        val VieocardValue = AddInfo.findViewById<TextView>(R.id.VideocardValue)
        VieocardValue.text = product.notebook.videocard.name
        val ProcessorValue = AddInfo.findViewById<TextView>(R.id.ProcessorValue)
        ProcessorValue.text = product.notebook.processor.name
        val ScreenTypeValue = AddInfo.findViewById<TextView>(R.id.ScreenTypeValue)
        ScreenTypeValue.text = product.notebook.screenType.name
        return AddInfo
    }

    fun getSmartphoneDetail(view: View?, product: Product): View? {
        val MemoryCountValue = view!!.findViewById<TextView>(R.id.MemoryCountValue)
        MemoryCountValue.text = product.smartphone.memoryCount.toString()
        val RamCountValue = view.findViewById<TextView>(R.id.RamCountValue)
        RamCountValue.text = product.smartphone.ramCount.toString()
        val BatteryCapacityValue = view.findViewById<TextView>(R.id.BatteryCapacityValue)
        BatteryCapacityValue.text = product.smartphone.batteryCapacity.toString()
        val CameraValue = view.findViewById<TextView>(R.id.CameraValue)
        CameraValue.text = product.smartphone.camera.toString()
        val PhoneSizeValue = view.findViewById<TextView>(R.id.PhoneSizeValue)
        PhoneSizeValue.text = product.smartphone.phoneSize.toString()
        val WeightValue = view.findViewById<TextView>(R.id.WeightValue)
        WeightValue.text = product.smartphone.weight.toString()
        val NFCValue = view.findViewById<TextView>(R.id.NFCValue)
        NFCValue.text = product.smartphone.isNFC.toString()
        val CommunicationValue = view.findViewById<TextView>(R.id.CommunicationValue)
        CommunicationValue.text = product.smartphone.communication.toString()
        val ScreenSizeValue = view.findViewById<TextView>(R.id.ScreenSizeValue)
        ScreenSizeValue.text = product.smartphone.screenSize.toString()
        val OptionalValue = view.findViewById<TextView>(R.id.OptionalValue)
        OptionalValue.text = product.smartphone.optional.toString()
        val ScreenResolutionValue = view.findViewById<TextView>(R.id.ScreenResolutionValue)
        ScreenResolutionValue.text = product.smartphone.screenResolution.toString()
        val OSValue = view.findViewById<TextView>(R.id.OSValue)
        OSValue.text = product.smartphone.os.name.toString()
        val ProcessorValue = view.findViewById<TextView>(R.id.ProcessorValue)
        ProcessorValue.text = product.smartphone.processor.name.toString()
        val ScreenTypeValue = view.findViewById<TextView>(R.id.ScreenTypeValue)
        ScreenTypeValue.text = product.smartphone.screenType.name.toString()
        val ChargingTypeValue = view.findViewById<TextView>(R.id.ChargingTypeValue)
        ChargingTypeValue.text = product.smartphone.chargingType.name.toString()
        return view
    }

    fun getWirelessHeadphonesDetail(view: View?, product: Product): View? {
        val RadiusValue = view!!.findViewById<TextView>(R.id.RadiusValue)
        RadiusValue.text = product.wirelessHeadphones.radius.toString()
        val BatteryValue = view.findViewById<TextView>(R.id.BatteryValue)
        BatteryValue.text = product.wirelessHeadphones.battery.toString()
        val CaseBattery = view.findViewById<TextView>(R.id.CaseBatteryValue)
        CaseBattery.text = product.wirelessHeadphones.caseBattery.toString()
        val ChargingType = view.findViewById<TextView>(R.id.ChargingTypeValue)
        ChargingType.text = product.wirelessHeadphones.chargingType.name.toString()
        return view
    }

    fun getWireHeadphones(view: View?, product: Product): View? {
        val WireLength = view!!.findViewById<TextView>(R.id.WireLengthValue)
        WireLength.text = product.wireHeadphones.wireLenght.toString()
        val ConnectionType = view.findViewById<TextView>(R.id.ConnectionTypeValue)
        ConnectionType.text = product.wireHeadphones.connectionType.name
        return view
    }
}