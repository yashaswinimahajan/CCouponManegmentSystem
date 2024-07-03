package in.Coupon.com;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
public class DiscountCoupon implements Delayed {
	    private String couponCode;
	    private long expirationTime;

	    public DiscountCoupon(String couponCode, long delay, TimeUnit unit) {
	        this.couponCode = couponCode;
	        this.expirationTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(delay, unit);
	    }

	    @Override
	    public long getDelay(TimeUnit unit) {
	        long diff = expirationTime - System.currentTimeMillis();
	        return unit.convert(diff, TimeUnit.MILLISECONDS);
	    }

	    @Override
	    public int compareTo(Delayed other) {
	        if (this.expirationTime < ((DiscountCoupon) other).expirationTime) {
	            return -1;
	        }
	        if (this.expirationTime > ((DiscountCoupon) other).expirationTime) {
	            return 1;
	        }
	        return 0;
	    }

	    public String getCouponCode() {
	        return couponCode;
	    }
	}







