package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameOrder$SetOrderGameResponse extends MessageMicro<QQGameOrder$SetOrderGameResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34}, new String[]{"order_games", "ret", "msg"}, new Object[]{null, 0, ""}, QQGameOrder$SetOrderGameResponse.class);
    public final PBRepeatMessageField<QQGameOrder$OrderGame> order_games = PBField.initRepeatMessage(QQGameOrder$OrderGame.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436039msg = PBField.initString("");
}
