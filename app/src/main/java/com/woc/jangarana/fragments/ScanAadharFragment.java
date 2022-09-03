package com.woc.jangarana.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentScanAadharBinding;

import java.io.IOException;

public class ScanAadharFragment extends Fragment {

    FragmentScanAadharBinding binding;
    Context context;

    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;



    public ScanAadharFragment(Context context) {
        this.context = context;
    }

    public ScanAadharFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScanAadharBinding.inflate(inflater, container, false);

        binding.scanInitiate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.setDesiredBarcodeFormats((IntentIntegrator.QR_CODE));
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.initiateScan();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //    private void initialiseDetectorsAndSources() {
//
//        Toast.makeText(context, "Barcode scanner started", Toast.LENGTH_SHORT).show();
//
//        barcodeDetector = new BarcodeDetector.Builder(context)
//                .setBarcodeFormats(Barcode.ALL_FORMATS)
//                .build();
//
//        if(!barcodeDetector.isOperational()){
//            Toast.makeText(context, "Sorry, Couldn't setup the detector", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        cameraSource = new CameraSource
//                .Builder(context, barcodeDetector)
//                .setRequestedPreviewSize(1920, 1080)
//                .setRequestedFps(15.0f)
//                .setAutoFocusEnabled(true) //you should add this feature
//                .build();
//
//        binding.surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                try {
//                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//                        cameraSource.start(binding.surfaceView.getHolder());
//                    } else {
//                        ActivityCompat.requestPermissions(getActivity(), new
//                                String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//                Toast.makeText(context, "Moved", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                cameraSource.stop();
//            }
//        });
//
//
//        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
//            @Override
//            public void release() {
//                Toast.makeText(context, "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void receiveDetections(Detector.Detections<Barcode> detections) {
//                SparseArray<Barcode> barcodes = detections.getDetectedItems();
//                Toast.makeText(context, "Detect ", Toast.LENGTH_SHORT).show();
//                if (barcodes.size() != 0) {
//                    Toast.makeText(context, ""+barcodes.valueAt(0), Toast.LENGTH_SHORT).show();
//
//
//                }
//            }
//        });
//    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        cameraSource.release();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        initialiseDetectorsAndSources();
//    }
}

