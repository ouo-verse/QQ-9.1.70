package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_post$RspBody extends MessageMicro<nearby_troop_post$RspBody> {
    public static final int INT32_RESULT_FIELD_NUMBER = 2;
    public static final int MSG_SUBCMD0X1_RSP_NEARBYPOSTINFO_FIELD_NUMBER = 4;
    public static final int STR_ERRO_FIELD_NUMBER = 3;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_sub_cmd", "int32_result", "str_erro", "msg_subcmd0x1_rsp_nearbypostinfo"}, new Object[]{0, 0, "", null}, nearby_troop_post$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_erro = PBField.initString("");
    public nearby_troop_post$RspNearbyPostInfo msg_subcmd0x1_rsp_nearbypostinfo = new MessageMicro<nearby_troop_post$RspNearbyPostInfo>() { // from class: tencent.im.cs.nearby_troop_post.nearby_troop_post$RspNearbyPostInfo
        public static final int STR_DESC_FIELD_NUMBER = 2;
        public static final int STR_POST_ADDRESS_FIELD_NUMBER = 7;
        public static final int STR_POST_PICTURE_URL_FIELD_NUMBER = 6;
        public static final int STR_POST_TITLE_FIELD_NUMBER = 5;
        public static final int STR_POST_URL_FIELD_NUMBER = 8;
        public static final int STR_TITLE_FIELD_NUMBER = 1;
        public static final int STR_TITLE_URL_FIELD_NUMBER = 3;
        public static final int UINT32_DISTANCE_FIELD_NUMBER = 4;
        public static final int UINT32_POST_REPLYS_FIELD_NUMBER = 9;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 72}, new String[]{"str_title", "str_desc", "str_title_url", "uint32_distance", "str_post_title", "str_post_picture_url", "str_post_address", "str_post_url", "uint32_post_replys"}, new Object[]{"", "", "", 0, "", "", "", "", 0}, nearby_troop_post$RspNearbyPostInfo.class);
        public final PBStringField str_title = PBField.initString("");
        public final PBStringField str_desc = PBField.initString("");
        public final PBStringField str_title_url = PBField.initString("");
        public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
        public final PBStringField str_post_title = PBField.initString("");
        public final PBStringField str_post_picture_url = PBField.initString("");
        public final PBStringField str_post_address = PBField.initString("");
        public final PBStringField str_post_url = PBField.initString("");
        public final PBUInt32Field uint32_post_replys = PBField.initUInt32(0);
    };
}
