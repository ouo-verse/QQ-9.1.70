package tencent.im;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class PasswdUrlReport$ReqBody extends MessageMicro<PasswdUrlReport$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QZoneAdTianshuFeedData.KEY_AD_TYPE, "upload_req_item"}, new Object[]{0, null}, PasswdUrlReport$ReqBody.class);
    public final PBInt32Field upload_type = PBField.initInt32(0);
    public PasswdUrlReport$UploadReqItem upload_req_item = new PasswdUrlReport$UploadReqItem();
}
