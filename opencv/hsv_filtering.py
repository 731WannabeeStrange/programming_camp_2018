import cv2
import numpy as np

cap = cv2.VideoCapture(0)

while(1):

    # Take each frame
    _, frame = cap.read()

    # Convert BGR to HSV
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    # define range of blue color in HSV
    lower_blue = np.array([100,50,50])
    upper_blue = np.array([115,255,255])

    # define range of red color in HSV
    lower_red = np.array([0,100,100])
    upper_red = np.array([15,255,255])

    # Threshold the HSV image to get only blue colors
    mask = cv2.inRange(hsv, lower_blue, upper_blue)

    # Threshold the HSV image to get only blue colors
    red_mask = cv2.inRange(hsv, lower_red, upper_red)

    image, contours_red, hierarchy = cv2.findContours(red_mask,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)

    for contour in contours_red:
        area = cv2.contourArea(contour)
        if area > 5000:
            M = cv2.moments(contour)
            cX = int(M["m10"] / M["m00"])
            cY = int(M["m01"] / M["m00"])

            font = cv2.FONT_HERSHEY_SIMPLEX
            cv2.putText(frame,'redthing',(cX,cY), font, 1, (200,255,155), 2, cv2.LINE_AA)

            cv2.drawContours(frame, [contour], -1, (0, 255, 0), 2)

    image, contours, hierarchy = cv2.findContours(mask,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)

    for contour in contours:
        area = cv2.contourArea(contour)
        if area > 5000:
            M = cv2.moments(contour)
            cX = int(M["m10"] / M["m00"])
            cY = int(M["m01"] / M["m00"])

            font = cv2.FONT_HERSHEY_SIMPLEX
            cv2.putText(frame,'bluething',(cX,cY), font, 1, (200,255,155), 2, cv2.LINE_AA)

            cv2.drawContours(frame, [contour], -1, (0, 255, 0), 2)


    # Bitwise-AND mask and original image
    res = cv2.bitwise_and(frame,frame, mask= mask)

    cv2.imshow('frame',frame)
    cv2.imshow('res',res)
    cv2.imshow('mask',mask)
    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
