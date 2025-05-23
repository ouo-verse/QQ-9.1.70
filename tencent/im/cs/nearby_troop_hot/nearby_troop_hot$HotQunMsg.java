package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_hot$HotQunMsg extends MessageMicro<nearby_troop_hot$HotQunMsg> {
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int EXT_FIELD_NUMBER = 5;
    public static final int MAGIC_FIELD_NUMBER = 1;
    public static final int MSG_REQ_BODY_FIELD_NUMBER = 10;
    public static final int MSG_RSP_BODY_FIELD_NUMBER = 11;
    public static final int SEQ_FIELD_NUMBER = 4;
    public static final int UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 82, 90}, new String[]{"magic", "uin", "cmd", "seq", "ext", "msg_req_body", "msg_rsp_body"}, new Object[]{0, 0L, 0, 0, null, null, null}, nearby_troop_hot$HotQunMsg.class);
    public final PBUInt32Field magic = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public nearby_troop_hot$ExtInfo ext = new MessageMicro<nearby_troop_hot$ExtInfo>() { // from class: tencent.im.cs.nearby_troop_hot.nearby_troop_hot$ExtInfo
        public static final int EXT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext"}, new Object[]{""}, nearby_troop_hot$ExtInfo.class);
        public final PBStringField ext = PBField.initString("");
    };
    public nearby_troop_hot$HotQunReq msg_req_body = new MessageMicro<nearby_troop_hot$HotQunReq>() { // from class: tencent.im.cs.nearby_troop_hot.nearby_troop_hot$HotQunReq
        public static final int GPS_FIELD_NUMBER = 4;
        public static final int PAGE_NUM_FIELD_NUMBER = 1;
        public static final int PAGE_SIZE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34}, new String[]{"page_num", "page_size", "gps"}, new Object[]{0, 0, null}, nearby_troop_hot$HotQunReq.class);
        public final PBUInt32Field page_num = PBField.initUInt32(0);
        public final PBUInt32Field page_size = PBField.initUInt32(0);
        public nearby_troop_hot$GPS gps = new nearby_troop_hot$GPS();
    };
    public nearby_troop_hot$HotQunRsp msg_rsp_body = new MessageMicro<nearby_troop_hot$HotQunRsp>() { // from class: tencent.im.cs.nearby_troop_hot.nearby_troop_hot$HotQunRsp
        public static final int QUN_INFO_FIELD_NUMBER = 2;
        public static final int QUN_ITEM_FIELD_NUMBER = 10;
        public static final int RET_INFO_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82}, new String[]{"ret_info", "qun_info", "qun_item"}, new Object[]{null, null, null}, nearby_troop_hot$HotQunRsp.class);
        public nearby_troop_hot$RetInfo ret_info = new MessageMicro<nearby_troop_hot$RetInfo>() { // from class: tencent.im.cs.nearby_troop_hot.nearby_troop_hot$RetInfo
            public static final int ERR_INFO_FIELD_NUMBER = 2;
            public static final int RET_CODE_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0, ""}, nearby_troop_hot$RetInfo.class);
            public final PBUInt32Field ret_code = PBField.initUInt32(0);
            public final PBStringField err_info = PBField.initString("");
        };
        public nearby_troop_hot$QunInfo qun_info = new MessageMicro<nearby_troop_hot$QunInfo>() { // from class: tencent.im.cs.nearby_troop_hot.nearby_troop_hot$QunInfo
            public static final int CNT_FIELD_NUMBER = 3;
            public static final int DESC_FIELD_NUMBER = 2;
            public static final int TITLE_FIELD_NUMBER = 1;
            public static final int URL_FIELD_NUMBER = 4;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"title", "desc", "cnt", "url"}, new Object[]{"", "", 0, ""}, nearby_troop_hot$QunInfo.class);
            public final PBStringField title = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
            public final PBUInt32Field cnt = PBField.initUInt32(0);
            public final PBStringField url = PBField.initString("");
        };
        public final PBRepeatMessageField<nearby_troop_hot$QunItem> qun_item = PBField.initRepeatMessage(nearby_troop_hot$QunItem.class);
    };
}
