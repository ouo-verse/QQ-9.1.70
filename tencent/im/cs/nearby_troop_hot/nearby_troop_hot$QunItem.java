package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_hot$QunItem extends MessageMicro<nearby_troop_hot$QunItem> {
    public static final int DESC_FIELD_NUMBER = 3;
    public static final int GPS_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uin", "title", "desc", "gps"}, new Object[]{0L, "", "", null}, nearby_troop_hot$QunItem.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public nearby_troop_hot$GPS gps = new nearby_troop_hot$GPS();
}
