package com.application.realtimefacedetection

import FaceGraphic
import android.content.Context
import android.util.Log
import com.application.realtimefacedetection.base.VisionProcessorBase
import com.application.realtimefacedetection.mlkit.GraphicOverlay
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetector
import com.google.mlkit.vision.face.FaceDetectorOptions

/** Face Detector Demo.  */
class FaceDetectorProcessor(context: Context) :
    VisionProcessorBase<List<Face>>(context) {

    private val detector: FaceDetector

    init {
        val options =
            FaceDetectorOptions.Builder()
                .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
                .build()


        detector = FaceDetection.getClient(options)

    }

    override fun stop() {
        super.stop()
        detector.close()
    }

    override fun detectInImage(image: InputImage): Task<List<Face>> {
        return detector.process(image)
    }

    override fun onSuccess(faces: List<Face>, graphicOverlay: GraphicOverlay) {
        for (face in faces) {
            graphicOverlay.add(FaceGraphic(graphicOverlay, face))
//            logExtrasForTesting(face)
        }
    }

    override fun onFailure(e: Exception) {
        Log.e(TAG, "Face detection failed $e")
    }

    companion object {
        private const val TAG = "FaceDetectorProcessor"

    }
}
