package tencent.im.oidb.cmd0xda2;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xda2$ReqBody extends MessageMicro<oidb_cmd0xda2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint32_req_type", "msg_get_vid_to_url_req"}, new Object[]{0, null}, oidb_cmd0xda2$ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public content_vidurl_svr$GetVid2UrlsReq msg_get_vid_to_url_req = new MessageMicro<content_vidurl_svr$GetVid2UrlsReq>() { // from class: tencent.im.oidb.cmd0xda2.content_vidurl_svr$GetVid2UrlsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90, 98}, new String[]{"uid", "appid", "client_ip", "net_type", "app_name", "app_version", "imei", "idfa", TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, AdParam.VIDS, "timestamp", "sign"}, new Object[]{"", "", "", 0, "", "", "", "", 0, "", "", ""}, content_vidurl_svr$GetVid2UrlsReq.class);
        public final PBStringField uid = PBField.initString("");
        public final PBStringField appid = PBField.initString("");
        public final PBStringField client_ip = PBField.initString("");
        public final PBUInt32Field net_type = PBField.initUInt32(0);
        public final PBStringField app_name = PBField.initString("");
        public final PBStringField app_version = PBField.initString("");
        public final PBStringField imei = PBField.initString("");
        public final PBStringField idfa = PBField.initString("");
        public final PBUInt32Field system = PBField.initUInt32(0);
        public final PBRepeatField<String> vids = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField timestamp = PBField.initString("");
        public final PBStringField sign = PBField.initString("");
    };
}
