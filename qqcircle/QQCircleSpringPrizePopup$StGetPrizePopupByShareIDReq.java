package qqcircle;

import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StGetPrizePopupByShareIDReq extends MessageMicro<QQCircleSpringPrizePopup$StGetPrizePopupByShareIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH}, new Object[]{""}, QQCircleSpringPrizePopup$StGetPrizePopupByShareIDReq.class);
    public final PBStringField share_id = PBField.initString("");
}
