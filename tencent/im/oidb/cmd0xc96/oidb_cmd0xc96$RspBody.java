package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc96$RspBody extends MessageMicro<oidb_cmd0xc96$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 90, 98, 106, 114}, new String[]{"wording", "next_req_duration", "appid", "app_type", "follow_rsp", "unfollow_rsp", "get_follow_info_rsp", "mget_follow_info_rsp"}, new Object[]{"", 0, 0L, 0, null, null, null, null}, oidb_cmd0xc96$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public oidb_cmd0xc96$FollowRsp follow_rsp = new MessageMicro<oidb_cmd0xc96$FollowRsp>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xc96$FollowRsp.class);
    };
    public oidb_cmd0xc96$UnfollowRsp unfollow_rsp = new MessageMicro<oidb_cmd0xc96$UnfollowRsp>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$UnfollowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xc96$UnfollowRsp.class);
    };
    public oidb_cmd0xc96$GetFollowInfoRsp get_follow_info_rsp = new MessageMicro<oidb_cmd0xc96$GetFollowInfoRsp>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$GetFollowInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"follow_info"}, new Object[]{null}, oidb_cmd0xc96$GetFollowInfoRsp.class);
        public oidb_cmd0xc96$FollowInfo follow_info = new MessageMicro<oidb_cmd0xc96$FollowInfo>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"openid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_IS_FOLLOWED, "follow_time"}, new Object[]{"", Boolean.FALSE, 0}, oidb_cmd0xc96$FollowInfo.class);
            public final PBStringField openid = PBField.initString("");
            public final PBBoolField is_followed = PBField.initBool(false);
            public final PBUInt32Field follow_time = PBField.initUInt32(0);
        };
    };
    public oidb_cmd0xc96$MGetFollowInfoRsp mget_follow_info_rsp = new MessageMicro<oidb_cmd0xc96$MGetFollowInfoRsp>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$MGetFollowInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"follow_info"}, new Object[]{null}, oidb_cmd0xc96$MGetFollowInfoRsp.class);
        public final PBRepeatMessageField<oidb_cmd0xc96$FollowInfo> follow_info = PBField.initRepeatMessage(oidb_cmd0xc96$FollowInfo.class);
    };
}
