package vp;

import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a {
    public static PhotoCommonBaseData a() {
        try {
            Constructor declaredConstructor = PhotoCommonBaseData.class.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return (PhotoCommonBaseData) declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            ms.a.c("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
            return PhotoCommonBaseData.getInstance();
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            ms.a.c("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
            return PhotoCommonBaseData.getInstance();
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            ms.a.c("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
            return PhotoCommonBaseData.getInstance();
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            ms.a.c("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
            return PhotoCommonBaseData.getInstance();
        }
    }
}
