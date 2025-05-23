package zr;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import hr.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static String c(ArrayList<DynamicStickerData> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<DynamicStickerData> it = arrayList.iterator();
            while (it.hasNext()) {
                DynamicStickerData next = it.next();
                if (next != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("centerP_x", next.centerP.x);
                    jSONObject.put("centerP_y", next.centerP.y);
                    jSONObject.put("scale", next.scale);
                    jSONObject.put(CanvasView.ACTION_ROTATE, next.rotate);
                    jSONObject.put("translateX", next.translateX);
                    jSONObject.put("translateY", next.translateY);
                    jSONObject.put("width", next.width);
                    jSONObject.put("height", next.height);
                    jSONObject.put("path", next.path);
                    jSONObject.put("type", next.type);
                    jSONObject.put("data", next.data);
                    jSONObject.put("layerWidth", next.layerWidth);
                    jSONObject.put("layerHeight", next.layerHeight);
                    jSONArray.mo162put(jSONObject);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            if (QLog.isColorLevel()) {
                QLog.d("DoodleUtil", 2, "DynamicStickersToJson result= " + jSONObject2.toString());
            }
            return jSONObject2.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleUtil", 2, "e= " + e16);
            }
            return null;
        }
    }

    public static FaceLayer.d g(vr.a aVar, float f16, float f17, float f18) {
        return new FaceLayer.d(f16, f17, f18, 0.0f, 0.0f, 0.0f, aVar.f443183c.getIntrinsicWidth(), aVar.f443183c.getIntrinsicHeight());
    }

    public static boolean a(e.a aVar) {
        if (aVar == null) {
            hd0.c.g("DoodleUtil", "item is null.");
            return false;
        }
        if (TextUtils.isEmpty(aVar.f406051f)) {
            hd0.c.g("DoodleUtil", "item layoutJson is empty,can't parse.");
            return false;
        }
        if (!aVar.a()) {
            hd0.c.g("DoodleUtil", "parseJson error:" + aVar.f406051f);
            return false;
        }
        e.a.C10470a c10470a = aVar.f406052g;
        if (c10470a.f406059d < 0) {
            hd0.c.g("DoodleUtil", "item textSize < 0. textSize:" + aVar.f406052g.f406059d);
            return false;
        }
        if (c10470a.f406060e > 0 && c10470a.f406061f > 0) {
            if (c10470a.f406062g > 0 && c10470a.f406063h > 0) {
                try {
                    Color.parseColor(c10470a.f406058c);
                    return true;
                } catch (Exception e16) {
                    hd0.c.g("DoodleUtil", "item color is illegal:" + aVar.f406052g.f406058c);
                    e16.printStackTrace();
                    return false;
                }
            }
            hd0.c.g("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + aVar.f406052g.f406062g + ",standardHeight:" + aVar.f406052g.f406063h);
            return false;
        }
        hd0.c.g("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + aVar.f406052g.f406060e + ",pictureHeight:" + aVar.f406052g.f406061f);
        return false;
    }

    public static FaceLayer.d d(e.a aVar, int i3, int i16, float f16, float f17) {
        int i17;
        int i18;
        if (!a(aVar)) {
            return null;
        }
        hd0.c.a("DoodleUtil", "item:" + aVar.toString());
        Drawable drawable = aVar.f406050e;
        if (drawable != null) {
            int width = drawable.getBounds().width();
            i17 = aVar.f406050e.getBounds().height();
            i18 = width;
        } else {
            i17 = 0;
            i18 = 0;
        }
        e.a.C10470a c10470a = aVar.f406052g;
        float f18 = c10470a.f406060e;
        int i19 = (int) ((c10470a.f406059d / c10470a.f406061f) * i17);
        FaceLayer.d dVar = new FaceLayer.d(f16, f17, (f18 * (i3 / c10470a.f406062g)) / i18, 0.0f, 0.0f, 0.0f, i18, i17 + (f(aVar.f406047b, i19, i18) * 2) + 32, aVar.f406047b, Color.parseColor(aVar.f406052g.f406058c), i19);
        hd0.c.a("DoodleUtil", "LayerParams:" + dVar.toString());
        return dVar;
    }

    public static FaceLayer.d e(e.a aVar, int i3, int i16, float f16, float f17, float f18) {
        int i17;
        int i18;
        if (!a(aVar)) {
            return null;
        }
        hd0.c.a("DoodleUtil", "item:" + aVar.toString());
        Drawable drawable = aVar.f406050e;
        if (drawable != null) {
            int width = drawable.getBounds().width();
            i17 = aVar.f406050e.getBounds().height();
            i18 = width;
        } else {
            i17 = 0;
            i18 = 0;
        }
        int i19 = aVar.f406052g.f406060e;
        int i26 = (int) ((r1.f406059d / r1.f406061f) * i17);
        FaceLayer.d dVar = new FaceLayer.d(f16, f17, (i3 * f18) / i18, 0.0f, 0.0f, 0.0f, i18, i17 + (f(aVar.f406047b, i26, i18) * 2) + 32, aVar.f406047b, Color.parseColor(aVar.f406052g.f406058c), i26);
        hd0.c.a("DoodleUtil", "LayerParams:" + dVar.toString());
        return dVar;
    }

    private static int f(String str, int i3, int i16) {
        if (i3 > 0 && i16 > 0 && !StringUtil.isEmpty(str)) {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(i3);
            StaticLayout staticLayout = new StaticLayout(str, textPaint, i16, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            Rect rect = new Rect();
            staticLayout.getLineBounds(0, rect);
            return rect.height();
        }
        if (!QLog.isColorLevel()) {
            return 1;
        }
        QLog.d("DoodleUtil", 2, "getLineHeight quit:" + i3 + " " + i16 + " " + str);
        return 1;
    }

    public static void b(Bitmap bitmap, int i3) {
        int[] iArr = new int[i3 * i3];
        int height = bitmap.getHeight() / i3;
        int width = bitmap.getWidth() / i3;
        int height2 = bitmap.getHeight() % i3;
        int width2 = bitmap.getWidth() % i3;
        int i16 = 0;
        while (i16 < height) {
            int i17 = 0;
            while (i17 < width) {
                int i18 = i16 * i3;
                int i19 = i17 * i3;
                int i26 = i17;
                int i27 = i16;
                bitmap.getPixels(iArr, 0, i3, i19, i18, i3, i3);
                int i28 = 0;
                int i29 = 0;
                int i36 = 0;
                for (int i37 = 0; i37 < i3; i37++) {
                    for (int i38 = 0; i38 < i3; i38++) {
                        int i39 = iArr[(i37 * i3) + i38];
                        i28 += (i39 >> 16) & 255;
                        i29 += (i39 >> 8) & 255;
                        i36 += i39 & 255;
                    }
                }
                int i46 = (i28 / i3) / i3;
                int i47 = (i29 / i3) / i3;
                int i48 = (i36 / i3) / i3;
                for (int i49 = 0; i49 < i3; i49++) {
                    for (int i56 = 0; i56 < i3; i56++) {
                        iArr[(i49 * i3) + i56] = (i46 << 16) | (-16777216) | (i47 << 8) | i48;
                    }
                }
                bitmap.setPixels(iArr, 0, i3, i19, i18, i3, i3);
                i17 = i26 + 1;
                i16 = i27;
            }
            i16++;
        }
        if (width2 > 0) {
            for (int i57 = 0; i57 < height; i57++) {
                int i58 = i57 * i3;
                int i59 = width * i3;
                int i65 = 0;
                int i66 = 0;
                int i67 = 0;
                for (int i68 = 0; i68 < i3; i68++) {
                    for (int i69 = 0; i69 < width2; i69++) {
                        int pixel = bitmap.getPixel(i59 + i69, i58 + i68);
                        i65 += (pixel >> 16) & 255;
                        i66 += (pixel >> 8) & 255;
                        i67 += pixel & 255;
                    }
                }
                int i75 = (i65 / i3) / width2;
                int i76 = (i66 / i3) / width2;
                int i77 = (i67 / i3) / width2;
                for (int i78 = 0; i78 < i3; i78++) {
                    int i79 = 0;
                    while (i79 < width2) {
                        bitmap.setPixel(i59 + i79, i58 + i78, (i75 << 16) | (-16777216) | (i76 << 8) | i77);
                        i79++;
                        i58 = i58;
                    }
                }
            }
        }
        if (height2 > 0) {
            for (int i85 = 0; i85 < width; i85++) {
                int i86 = height * i3;
                int i87 = i85 * i3;
                int i88 = 0;
                int i89 = 0;
                int i95 = 0;
                for (int i96 = 0; i96 < height2; i96++) {
                    for (int i97 = 0; i97 < i3; i97++) {
                        int pixel2 = bitmap.getPixel(i87 + i97, i86 + i96);
                        i88 += (pixel2 >> 16) & 255;
                        i89 += (pixel2 >> 8) & 255;
                        i95 += pixel2 & 255;
                    }
                }
                int i98 = (i88 / i3) / height2;
                int i99 = (i89 / i3) / height2;
                int i100 = (i95 / i3) / height2;
                for (int i101 = 0; i101 < height2; i101++) {
                    for (int i102 = 0; i102 < i3; i102++) {
                        bitmap.setPixel(i87 + i102, i86 + i101, (i98 << 16) | (-16777216) | (i99 << 8) | i100);
                    }
                }
            }
        }
    }
}
