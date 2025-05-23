package tencent.im.oidb.cmd0xc96;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc96$ReqBody extends MessageMicro<oidb_cmd0xc96$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 90, 98, 106, 114}, new String[]{"appid", "app_type", IPublicAccountBrowser.KEY_PUB_UIN, "cmd_type", "follow_req", "unfollow_req", "get_follow_info_req", "mget_follow_info_req"}, new Object[]{0L, 0, 0L, 0, null, null, null, null}, oidb_cmd0xc96$ReqBody.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public oidb_cmd0xc96$FollowReq follow_req = new oidb_cmd0xc96$FollowReq();
    public oidb_cmd0xc96$UnfollowReq unfollow_req = new oidb_cmd0xc96$UnfollowReq();
    public oidb_cmd0xc96$GetFollowInfoReq get_follow_info_req = new MessageMicro<oidb_cmd0xc96$GetFollowInfoReq>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$GetFollowInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xc96$GetFollowInfoReq.class);
    };
    public oidb_cmd0xc96$MGetFollowInfoReq mget_follow_info_req = new MessageMicro<oidb_cmd0xc96$MGetFollowInfoReq>() { // from class: tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$MGetFollowInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{GetCMShowInfoServlet.EXTRA_OPENID}, new Object[]{""}, oidb_cmd0xc96$MGetFollowInfoReq.class);
        public final PBRepeatField<String> openids = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
