package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$GroupInfo extends MessageMicro<group_mgr$GroupInfo> {
    public static final int COMMON_FIELD_NUMBER = 1;
    public static final int HWINFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"common", "hwinfo"}, new Object[]{null, null}, group_mgr$GroupInfo.class);

    /* renamed from: common, reason: collision with root package name */
    public group_mgr$GroupCommInfo f435949common = new MessageMicro<group_mgr$GroupCommInfo>() { // from class: tencent.im.hw.group_mgr$GroupCommInfo
        public static final int GROUP_CLASS_FIELD_NUMBER = 4;
        public static final int GROUP_NAME_FIELD_NUMBER = 2;
        public static final int GROUP_OPTION_FIELD_NUMBER = 1;
        public static final int GROUP_SIZE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"group_option", "group_name", "group_size", "group_class"}, new Object[]{0, "", 0, 0}, group_mgr$GroupCommInfo.class);
        public final PBUInt32Field group_option = PBField.initUInt32(0);
        public final PBStringField group_name = PBField.initString("");
        public final PBUInt32Field group_size = PBField.initUInt32(0);
        public final PBUInt32Field group_class = PBField.initUInt32(0);
    };
    public group_mgr$GroupHomeworkInfo hwinfo = new MessageMicro<group_mgr$GroupHomeworkInfo>() { // from class: tencent.im.hw.group_mgr$GroupHomeworkInfo
        public static final int CITY_CODE_FIELD_NUMBER = 1;
        public static final int CL_CLASS_FIELD_NUMBER = 6;
        public static final int CL_ENROL_YEAR_FIELD_NUMBER = 4;
        public static final int CL_GRADE_FIELD_NUMBER = 5;
        public static final int SC_NAME_FIELD_NUMBER = 3;
        public static final int SC_TYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"city_code", "sc_type", "sc_name", "cl_enrol_year", "cl_grade", "cl_class"}, new Object[]{"", "", "", "", "", ""}, group_mgr$GroupHomeworkInfo.class);
        public final PBStringField city_code = PBField.initString("");
        public final PBStringField sc_type = PBField.initString("");
        public final PBStringField sc_name = PBField.initString("");
        public final PBStringField cl_enrol_year = PBField.initString("");
        public final PBStringField cl_grade = PBField.initString("");
        public final PBStringField cl_class = PBField.initString("");
    };
}
