package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class member_lbs$NeighbourInfo extends MessageMicro<member_lbs$NeighbourInfo> {
    public static final int DOUBLE_DISTANCE_FIELD_NUMBER = 4;
    public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
    public static final int INT64_LONGITUDE_FIELD_NUMBER = 3;
    public static final int STR_NICK_FIELD_NUMBER = 7;
    public static final int UINT32_AGE_FIELD_NUMBER = 6;
    public static final int UINT32_SEX_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 33, 40, 48, 58}, new String[]{"uint64_uin", "int64_latitude", "int64_longitude", "double_distance", "uint32_sex", "uint32_age", "str_nick"}, new Object[]{0L, 0L, 0L, Double.valueOf(0.0d), 0, 0, ByteStringMicro.EMPTY}, member_lbs$NeighbourInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBInt64Field int64_latitude = PBField.initInt64(0);
    public final PBInt64Field int64_longitude = PBField.initInt64(0);
    public final PBDoubleField double_distance = PBField.initDouble(0.0d);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBBytesField str_nick = PBField.initBytes(ByteStringMicro.EMPTY);
}
