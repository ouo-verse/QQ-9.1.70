package tencent.im.cs.nearby_troop_hot;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nearby_troop_hot$GPS extends MessageMicro<nearby_troop_hot$GPS> {
    public static final int LATITUDE_FIELD_NUMBER = 2;
    public static final int LONGTITUDE_FIELD_NUMBER = 1;
    public static final int RANGE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"longtitude", "latitude", DownloaderConstant.KEY_RANGE}, new Object[]{0L, 0L, 0L}, nearby_troop_hot$GPS.class);
    public final PBUInt64Field longtitude = PBField.initUInt64(0);
    public final PBUInt64Field latitude = PBField.initUInt64(0);
    public final PBUInt64Field range = PBField.initUInt64(0);
}
