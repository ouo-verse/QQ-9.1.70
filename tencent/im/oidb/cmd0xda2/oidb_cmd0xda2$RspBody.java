package tencent.im.oidb.cmd0xda2;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xda2$RspBody extends MessageMicro<oidb_cmd0xda2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"msg_get_vid_to_url_rsp"}, new Object[]{null}, oidb_cmd0xda2$RspBody.class);
    public content_vidurl_svr$GetVid2UrlsRsp msg_get_vid_to_url_rsp = new MessageMicro<content_vidurl_svr$GetVid2UrlsRsp>() { // from class: tencent.im.oidb.cmd0xda2.content_vidurl_svr$GetVid2UrlsRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", CoverDBCacheData.URLS}, new Object[]{0, "", null}, content_vidurl_svr$GetVid2UrlsRsp.class);
        public final PBUInt32Field ret_code = PBField.initUInt32(0);
        public final PBStringField ret_msg = PBField.initString("");
        public final PBRepeatMessageField<content_vidurl_svr$UrlInfo> urls = PBField.initRepeatMessage(content_vidurl_svr$UrlInfo.class);
    };
}
