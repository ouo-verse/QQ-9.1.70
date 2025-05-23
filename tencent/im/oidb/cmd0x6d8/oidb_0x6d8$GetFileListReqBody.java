package tencent.im.oidb.cmd0x6d8;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d8$GetFileListReqBody extends MessageMicro<oidb_0x6d8$GetFileListReqBody> {
    public static final int SORT_BY_DOWNLOAD = 6;
    public static final int SORT_BY_FILENAME = 4;
    public static final int SORT_BY_FILESIZE = 5;
    public static final int SORT_BY_FILETYPE = 2;
    public static final int SORT_BY_TIMESTAMP = 1;
    public static final int SORT_BY_UPLOADER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 144, 152}, new String[]{"uint64_group_code", "uint32_app_id", "str_folder_id", Element.ELEMENT_NAME_START_TIMESTAMP, "uint32_file_count", "max_timestamp", "uint32_all_file_count", "uint32_req_from", "uint32_sort_by", "uint32_filter_code", "uint64_uin", "uint32_field_flag", "uint32_start_index", "bytes_context", "uint32_client_version", "uint32_white_list", "uint32_sort_order", "uint32_show_onlinedoc_folder", "uint64_filter_uin_list"}, new Object[]{0L, 0, "", null, 0, null, 0, 0, 0, 0, 0L, 16777215, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0L}, oidb_0x6d8$GetFileListReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBStringField str_folder_id = PBField.initString("");
    public oidb_0x6d8$FileTimeStamp start_timestamp = new oidb_0x6d8$FileTimeStamp();
    public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
    public oidb_0x6d8$FileTimeStamp max_timestamp = new oidb_0x6d8$FileTimeStamp();
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_by = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_white_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_order = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_onlinedoc_folder = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_filter_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
