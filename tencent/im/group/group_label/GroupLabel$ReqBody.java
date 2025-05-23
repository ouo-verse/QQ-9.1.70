package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupLabel$ReqBody extends MessageMicro<GroupLabel$ReqBody> {
    public static final int RPT_GROUP_CODE_FIELD_NUMBER = 4;
    public static final int SOURCE_ID_FIELD_NUMBER = 1;
    public static final int UINT32_LABEL_STYLE_FIELD_NUMBER = 5;
    public static final int UINT32_NUMBER_LABEL_FIELD_NUMBER = 3;
    public static final int UIN_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"source_id", "uin_info", "uint32_number_label", "rpt_group_code", "uint32_label_style"}, new Object[]{null, null, 5, 0L, 0}, GroupLabel$ReqBody.class);
    public GroupLabel$SourceId source_id = new MessageMicro<GroupLabel$SourceId>() { // from class: tencent.im.group.group_label.GroupLabel$SourceId
        public static final int UINT32_SOURCE_ID_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_source_id"}, new Object[]{0}, GroupLabel$SourceId.class);
        public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    };
    public GroupLabel$UinInfo uin_info = new MessageMicro<GroupLabel$UinInfo>() { // from class: tencent.im.group.group_label.GroupLabel$UinInfo
        public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
        public static final int INT64_LONGITUDE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_longitude", "int64_latitude"}, new Object[]{0L, 0L}, GroupLabel$UinInfo.class);
        public final PBInt64Field int64_longitude = PBField.initInt64(0);
        public final PBInt64Field int64_latitude = PBField.initInt64(0);
    };
    public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
    public final PBRepeatField<Long> rpt_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
}
