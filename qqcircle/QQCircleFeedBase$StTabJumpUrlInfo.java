package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTabJumpUrlInfo extends MessageMicro<QQCircleFeedBase$StTabJumpUrlInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{WadlProxyConsts.KEY_JUMP_URL}, new Object[]{""}, QQCircleFeedBase$StTabJumpUrlInfo.class);
    public final PBStringField jumpUrl = PBField.initString("");
}
