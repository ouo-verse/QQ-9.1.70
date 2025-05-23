package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class member_lbs$RspBody extends MessageMicro<member_lbs$RspBody> {
    public static final int BOOL_SHOW_TIPS_FIELD_NUMBER = 6;
    public static final int MSG_LOCATION_FIELD_NUMBER = 3;
    public static final int MSG_MEMS_DISTANCE_FIELD_NUMBER = 5;
    public static final int MSG_NEIGHBOUR_NUMBER_FIELD_NUMBER = 4;
    public static final int RPT_MSG_NEIGHBOURS_INFO_FIELD_NUMBER = 10;
    public static final int STR_RESULT_INFO_FIELD_NUMBER = 2;
    public static final int STR_TIPS_NATIVE_URL_FIELD_NUMBER = 8;
    public static final int STR_TIPS_WEB_URL_FIELD_NUMBER = 9;
    public static final int STR_TIPS_WORDING_FIELD_NUMBER = 7;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_show_tips;
    public member_lbs$Location msg_location;
    public member_lbs$MemsDistance msg_mems_distance;
    public member_lbs$NeighbourNumber msg_neighbour_number;
    public final PBRepeatMessageField<member_lbs$NeighbourInfo> rpt_msg_neighbours_info;
    public final PBBytesField str_result_info;
    public final PBBytesField str_tips_native_url;
    public final PBBytesField str_tips_web_url;
    public final PBBytesField str_tips_wording;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 66, 74, 82}, new String[]{"uint32_result", "str_result_info", "msg_location", "msg_neighbour_number", "msg_mems_distance", "bool_show_tips", "str_tips_wording", "str_tips_native_url", "str_tips_web_url", "rpt_msg_neighbours_info"}, new Object[]{0, byteStringMicro, null, null, null, Boolean.FALSE, byteStringMicro, byteStringMicro, byteStringMicro, null}, member_lbs$RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [tencent.im.lbs.member_lbs$Location] */
    /* JADX WARN: Type inference failed for: r2v2, types: [tencent.im.lbs.member_lbs$NeighbourNumber] */
    /* JADX WARN: Type inference failed for: r2v3, types: [tencent.im.lbs.member_lbs$MemsDistance] */
    public member_lbs$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_result_info = PBField.initBytes(byteStringMicro);
        this.msg_location = new MessageMicro<member_lbs$Location>() { // from class: tencent.im.lbs.member_lbs$Location
            public static final int INT64_LATITUDE_FIELD_NUMBER = 1;
            public static final int INT64_LONGITUDE_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_latitude", "int64_longitude"}, new Object[]{0L, 0L}, member_lbs$Location.class);
            public final PBInt64Field int64_latitude = PBField.initInt64(0);
            public final PBInt64Field int64_longitude = PBField.initInt64(0);
        };
        this.msg_neighbour_number = new MessageMicro<member_lbs$NeighbourNumber>() { // from class: tencent.im.lbs.member_lbs$NeighbourNumber
            public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
            public static final int UINT64_LOCATED_NUMBER_FIELD_NUMBER = 3;
            public static final int UINT64_NEIGHBOUR_NUMBER_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_group_code", "uint64_neighbour_number", "uint64_located_number"}, new Object[]{0L, 0L, 0L}, member_lbs$NeighbourNumber.class);
            public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
            public final PBUInt64Field uint64_neighbour_number = PBField.initUInt64(0);
            public final PBUInt64Field uint64_located_number = PBField.initUInt64(0);
        };
        this.msg_mems_distance = new MessageMicro<member_lbs$MemsDistance>() { // from class: tencent.im.lbs.member_lbs$MemsDistance
            public static final int INT64_DISTANCE_FIELD_NUMBER = 2;
            public static final int UINT64_UIN_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "int64_distance"}, new Object[]{0L, 0L}, member_lbs$MemsDistance.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBInt64Field int64_distance = PBField.initInt64(0);
        };
        this.bool_show_tips = PBField.initBool(false);
        this.str_tips_wording = PBField.initBytes(byteStringMicro);
        this.str_tips_native_url = PBField.initBytes(byteStringMicro);
        this.str_tips_web_url = PBField.initBytes(byteStringMicro);
        this.rpt_msg_neighbours_info = PBField.initRepeatMessage(member_lbs$NeighbourInfo.class);
    }
}
