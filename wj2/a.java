package wj2;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qqvideoedit.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditDataWrapper;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoStickerModelExtra;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079 A[Catch: IOException -> 0x007d, TRY_LEAVE, TryCatch #4 {IOException -> 0x007d, blocks: (B:33:0x0074, B:35:0x0079), top: B:32:0x0074 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoEditDataWrapper a(String str) {
        Throwable th5;
        ObjectInputStream objectInputStream;
        if (TextUtils.isEmpty(str)) {
            ms.a.c("VideoEditDataHelper", "missionId is null");
            return null;
        }
        String c16 = AECameraPrefsUtil.b().c(AECameraPrefsUtil.f275091f + str, "", 4);
        if (!TextUtils.isEmpty(c16)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(c16, 0));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                objectInputStream = null;
                try {
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                    }
                } catch (IOException e17) {
                    ms.a.e("VideoEditDataHelper", e17);
                }
                throw th5;
            }
            try {
                try {
                    VideoEditDataWrapper videoEditDataWrapper = (VideoEditDataWrapper) objectInputStream.readObject();
                    b(videoEditDataWrapper);
                    try {
                        byteArrayInputStream.close();
                        objectInputStream.close();
                    } catch (IOException e18) {
                        ms.a.e("VideoEditDataHelper", e18);
                    }
                    return videoEditDataWrapper;
                } catch (Throwable th7) {
                    th5 = th7;
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                e = e19;
                ms.a.e("VideoEditDataHelper", e);
                try {
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (IOException e26) {
                    ms.a.e("VideoEditDataHelper", e26);
                }
                return null;
            }
        }
        ms.a.c("VideoEditDataHelper", "getMediaModelFromDraft error media is null");
        return null;
    }

    private static void b(VideoEditDataWrapper videoEditDataWrapper) {
        ArrayList<VideoEditData> editData;
        if (videoEditDataWrapper != null && (editData = videoEditDataWrapper.getEditData()) != null && editData.size() > 0) {
            Iterator<VideoEditData> it = editData.iterator();
            while (it.hasNext()) {
                VideoEditData next = it.next();
                if (next.getStickerModelMap() != null) {
                    Iterator<String> it5 = next.getStickerModelMap().keySet().iterator();
                    while (it5.hasNext()) {
                        String next2 = it5.next();
                        if (next.getStickerExtraMap() != null) {
                            VideoStickerModel videoStickerModel = next.getStickerModelMap().get(next2);
                            VideoStickerModelExtra videoStickerModelExtra = next.getStickerExtraMap().get(next2);
                            if (videoStickerModel != null || videoStickerModelExtra != null) {
                                if (videoStickerModel != null && videoStickerModelExtra != null) {
                                    VideoEditData videoEditData = next;
                                    VideoStickerModel videoStickerModel2 = new VideoStickerModel(videoStickerModel.id, videoStickerModel.filePath, videoStickerModel.startTime, videoStickerModel.duration, videoStickerModel.layerIndex, videoStickerModel.scale, videoStickerModel.rotate, videoStickerModel.centerX, videoStickerModel.centerY, videoStickerModel.editable, videoStickerModel.width, videoStickerModel.height, videoStickerModel.minScale, videoStickerModel.maxScale, videoStickerModel.textItems, videoStickerModel.thumbUrl, videoStickerModel.timelineTrackIndex, videoStickerModel.animationMode, videoStickerModel.type, videoStickerModel.materialId, videoStickerModel.captionInfo, videoStickerModel.localThumbId, videoStickerModel.editingLayerIndex, videoStickerModel.playEndDuration, videoStickerModel.actionType, videoStickerModel.bgConfig, videoStickerModel.bgPath, videoStickerModel.configType, videoStickerModel.unknownFields(), videoStickerModelExtra.getInitStickerScale(), videoStickerModelExtra.getDownScaleRecord(), videoStickerModelExtra.getOriginPointInView(), videoStickerModelExtra.getSizeInView(), videoStickerModelExtra.getCenterInView(), videoStickerModelExtra.getLeftTopInView(), videoStickerModelExtra.getRightBottomInView(), videoStickerModelExtra.getMaterial());
                                    videoStickerModel2.setLastDownScale(videoStickerModelExtra.getLastDownScale());
                                    videoStickerModel2.setLastDownRotate(videoStickerModelExtra.getLastDownRotate());
                                    videoEditData.getStickerModelMap().put(next2, videoStickerModel2);
                                    it = it;
                                    it5 = it5;
                                    next = videoEditData;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void c(VideoEditDataWrapper videoEditDataWrapper, String str) {
        ObjectOutputStream objectOutputStream;
        if (videoEditDataWrapper == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                objectOutputStream.writeObject(videoEditDataWrapper);
                String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                AECameraPrefsUtil.b().e(AECameraPrefsUtil.f275091f + str, str2, 4);
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream2 = objectOutputStream;
                try {
                    ms.a.e("VideoEditDataHelper", th);
                    byteArrayOutputStream.close();
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                    } catch (IOException e16) {
                        ms.a.e("VideoEditDataHelper", e16);
                    }
                    throw th7;
                }
            }
        } catch (IOException e17) {
            ms.a.e("VideoEditDataHelper", e17);
        }
    }
}
